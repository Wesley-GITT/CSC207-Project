package interface_adapter.product.view;

import interface_adapter.book.view.BookState;
import interface_adapter.book.view.BookViewModel;
import interface_adapter.user.show_other_profile.ShowOtherProfileState;
import interface_adapter.user.show_other_profile.ShowOtherProfileViewModel;
import use_case.book.view.ViewBookOutputBoundary;
import use_case.book.view.ViewBookOutputData;
import use_case.product.view.ViewProductOutputBoundary;
import use_case.product.view.ViewProductOutputData;
import use_case.user.show_other_profile.ShowOtherProfileOutputBoundary;
import use_case.user.show_other_profile.ShowOtherProfileOutputData;

/**
 * The Presenter for the Login Use Case.
 */
public class ProductPresenter implements
        ViewProductOutputBoundary, ViewBookOutputBoundary, ShowOtherProfileOutputBoundary {

    private final ProductViewModel productViewModel;
    private final BookViewModel bookViewModel;
    private final ShowOtherProfileViewModel showOtherProfileViewModel;

    public ProductPresenter(ProductViewModel productViewModel, BookViewModel bookViewModel,
                            ShowOtherProfileViewModel showOtherProfileViewModel) {
        this.productViewModel = productViewModel;
        this.bookViewModel = bookViewModel;
        this.showOtherProfileViewModel = showOtherProfileViewModel;
    }

    @Override
    public void prepareSuccessView(ViewProductOutputData response) {
        final ProductState state = productViewModel.getState();
        state.setProductId(response.getProductId());
        state.setBookId(response.getBookId());
        state.setBookCondition(response.getBookCondition());
        state.setPrice(response.getPrice());
        state.setSellerId(response.getSellerId());
        state.setSold(response.isSold());
        productViewModel.firePropertyChanged();
    }

    @Override
    public void prepareSuccessView(ViewBookOutputData response) {
        final BookState state = bookViewModel.getState();
        state.setId(response.getId());
        state.setImageUrl(response.getImageUrl());
        state.setTitle(response.getTitle());
        state.setAuthors(response.getAuthors());
        state.setDescription(response.getDescription());
        state.setLanguage(response.getLanguage());
        state.setPublisher(response.getPublisher());
        state.setPublishedDate(response.getPublishedDate());
        bookViewModel.firePropertyChanged();
    }

    @Override
    public void prepareSuccessView(ShowOtherProfileOutputData response) {
        final ShowOtherProfileState state = showOtherProfileViewModel.getState();
        state.setUsername(response.getUsername());
        state.setEmail(response.getEmail());
        state.setTelephone(response.getTelephone());
        showOtherProfileViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final ProductState state = productViewModel.getState();
        state.setViewProductError(error);
        productViewModel.firePropertyChanged();
    }
}
