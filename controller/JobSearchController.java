package controller;

import model.*;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JobSearchController {
    public SearchJobView getSearchJobView() {
        return searchJobView;
    }

    public void setSearchJobView(SearchJobView searchJobView) {
        this.searchJobView = searchJobView;
    }

    public NavigationController getNavigationController() {
        return navigationController;
    }

    public void setNavigationController(NavigationController navigationController) {
        this.navigationController = navigationController;
    }

    private SearchJobView searchJobView;

    private NavigationController navigationController;
    private User user;
    public JobSearchController(NavigationController navigationController, User user){
        this.navigationController = navigationController;
        this.user = user;

        /*
        searchJobView.addSearchJobButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get all field attributes and search term and run through matching algorithm
                SearchAlgorithmController searchAlgorithmController = new SearchAlgorithmController(navigationController, searchJobView, searchResultsView);
            }
        });

        //add event listeners for the search results page
        //we may need a searchResultsController to add the action listeners for the job details, maybe this can be done in the view.
        searchResultsView.addNextButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // only display if there are more results to paginate through
            }
        });

        searchResultsView.addPreviousButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // only display if not on first page
            }
        });

        searchResultsView.addSearchButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchResultsView.getSearchTextField().toString();
                //pass search term back to searchJobView
                navigationController.doBack();
            }
        });

         */
    }

    public void doSearch(String searchString) throws SQLException {

        //get all field attributes and search term and run through matching algorithm
        ArrayList<Keyword> keywords = createSearchQuery(searchString);
        // TODO: JobSearchView passes in parameters here, we have SearchAlgorithmController do the work, then call showResults
        SearchAlgorithmController searchAlgorithmController = new SearchAlgorithmController(navigationController, new JobSeeker(JobSeeker.getJobSeeker(user.getUserId())));
        searchAlgorithmController.showResults(keywords);
    }

    public ArrayList<Keyword> createSearchQuery(String searchString) throws SQLException {
        ArrayList<Keyword> keywords = new ArrayList<Keyword>();
        ArrayList<Keyword> removeDuplicateKeyword = new ArrayList<Keyword>();
        List<String> items = Arrays.asList(searchString.split("\\s+"));
        for (int i = 0; i < items.size(); i++)
        {
            keywords.add(new Keyword(items.get(i)));
        }
        keywords.add(new Keyword((String) searchJobView.getSalaryComboBox().getSelectedItem()));
        keywords.add(new Keyword((String) searchJobView.getCategoriesComboBox().getSelectedItem()));

        for (int i = 0; i < keywords.size(); i++)
        {
            ResultSet rs = Keyword.getKeywordByValueLike(keywords.get(i).getKeywordValue());
            keywords.get(i).setKeywordId(rs.getInt("keywordId"));
            keywords.get(i).setKeywordType(rs.getString("keywordType"));
            if (keywords.get(i).getKeywordId() == 0)
            {
                keywords.remove(i);
            }
        }
        for (int i = 0; i < keywords.size(); i++)
        {
            if (!removeDuplicateKeyword.contains(keywords.get(i)))
            {
                removeDuplicateKeyword.add(keywords.get(i));
                System.out.println(keywords.get(i).getKeywordValue());
            }
        }
        return removeDuplicateKeyword;

    }

    public void doProfileSearch() throws SQLException {
        // TODO: similar to the above, but we're just using the user profile data?
        System.out.println(user.getUserId());
        ArrayList<Keyword> keywords = createSearchQuery(JobSeeker.getJobSeeker(user.getUserId()).getString("skillIds"));
        SearchAlgorithmController searchAlgorithmController = new SearchAlgorithmController(navigationController, new JobSeeker(JobSeeker.getJobSeeker(user.getUserId())));
        searchAlgorithmController.showResults(keywords);


    }

    public void showSearch() throws SQLException {
        this.searchJobView = new SearchJobView(this);
        navigationController.pushView(searchJobView);
        loadCategories();
        loadLocations();
        loadSalary();
    }

    public void loadCategories() throws SQLException {
        ResultSet rs = Keyword.listCategories();
        searchJobView.getCategoriesComboBox().addItem("");
        while (rs.next())
        {
            searchJobView.getCategoriesComboBox().addItem(rs.getString("keywordValue"));
        }
    }

    public void loadLocations() throws SQLException {
        ResultSet rs = Location.listLocations();
        searchJobView.getLocationComboBox().addItem("");
        while (rs.next())
        {
            searchJobView.getLocationComboBox().addItem(rs.getString("city"));
        }
    }

    public void loadSalary() throws SQLException {
        ResultSet rs = Keyword.listSalary();
        searchJobView.getSalaryComboBox().addItem("");
        while (rs.next())
        {
            searchJobView.getSalaryComboBox().addItem(rs.getString("keywordValue"));
        }
    }
}
