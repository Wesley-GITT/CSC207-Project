package app;

import data_access.book.APIBookDataAccessObject;
import data_access.product.InMemoryProductDataAccessObject;
import data_access.user.InMemoryUserDataAccessObject;
import interface_adapter.book.search.SearchBookController;
import interface_adapter.book.search.SearchBookPresenter;
import interface_adapter.book.search.SearchBookViewModel;
import interface_adapter.book.view.BookController;
import interface_adapter.book.view.BookPresenter;
import interface_adapter.book.view.BookViewModel;
import interface_adapter.container.ViewManagerModel;
import interface_adapter.container.ViewManagerState;
import interface_adapter.product.list_book_products.ListBookProductController;
import interface_adapter.product.list_book_products.ListBookProductPresenter;
import interface_adapter.product.list_book_products.ListBookProductViewModel;
import interface_adapter.product.list_my_products.ListMyProductController;
import interface_adapter.product.list_my_products.ListMyProductPresenter;
import interface_adapter.product.list_my_products.ListMyProductViewModel;
import interface_adapter.product.remove.RemoveProductController;
import interface_adapter.product.remove.RemoveProductPresenter;
import interface_adapter.product.remove.RemoveProductViewModel;
import interface_adapter.product.update.CreateProductPresenter;
import interface_adapter.product.update.UpdateProductController;
import interface_adapter.product.update.UpdateProductPresenter;
import interface_adapter.product.update.UpdateProductViewModel;
import interface_adapter.product.view.ProductController;
import interface_adapter.product.view.ProductPresenter;
import interface_adapter.product.view.ProductViewModel;
import interface_adapter.user.auth.AuthController;
import interface_adapter.user.auth.AuthPresenter;
import interface_adapter.user.auth.AuthViewModel;
import interface_adapter.user.reg.RegController;
import interface_adapter.user.reg.RegPresenter;
import interface_adapter.user.reg.RegViewModel;
import interface_adapter.user.show_my_profile.ShowMyProfileController;
import interface_adapter.user.show_my_profile.ShowMyProfilePresenter;
import interface_adapter.user.show_my_profile.ShowMyProfileViewModel;
import interface_adapter.user.show_other_profile.ShowOtherProfileController;
import interface_adapter.user.show_other_profile.ShowOtherProfilePresenter;
import interface_adapter.user.show_other_profile.ShowOtherProfileViewModel;
import interface_adapter.user.show_wishlist.ShowWishlistController;
import interface_adapter.user.show_wishlist.ShowWishlistPresenter;
import interface_adapter.user.show_wishlist.ShowWishlistViewModel;
import interface_adapter.user.update_my_profile.UpdateMyProfileController;
import interface_adapter.user.update_my_profile.UpdateMyProfilePresenter;
import interface_adapter.user.update_my_profile.UpdateMyProfileViewModel;
import interface_adapter.user.update_name.UpdateNameController;
import interface_adapter.user.update_name.UpdateNamePresenter;
import interface_adapter.user.update_name.UpdateNameViewModel;
import interface_adapter.user.update_pwd.UpdatePasswordController;
import interface_adapter.user.update_pwd.UpdatePasswordPresenter;
import interface_adapter.user.update_pwd.UpdatePasswordViewModel;
import interface_adapter.user.update_wishlist.UpdateWishlistController;
import interface_adapter.user.update_wishlist.UpdateWishlistPresenter;
import interface_adapter.user.update_wishlist.UpdateWishlistViewModel;
import use_case.book.search.SearchBookInputBoundary;
import use_case.book.search.SearchBookInteractor;
import use_case.book.search.SearchBookOutputBoundary;
import use_case.book.view.ViewBookInputBoundary;
import use_case.book.view.ViewBookInteractor;
import use_case.book.view.ViewBookOutputBoundary;
import use_case.product.create.CreateProductInputBoundary;
import use_case.product.create.CreateProductInteractor;
import use_case.product.list_book_products.ListBookProductInputBoundary;
import use_case.product.list_book_products.ListBookProductInteractor;
import use_case.product.list_book_products.ListBookProductOutputBoundary;
import use_case.product.list_my_products.ListMyProductInputBoundary;
import use_case.product.list_my_products.ListMyProductInteractor;
import use_case.product.list_my_products.ListMyProductOutputBoundary;
import use_case.product.remove.RemoveProductInputBoundary;
import use_case.product.remove.RemoveProductInteractor;
import use_case.product.remove.RemoveProductOutputBoundary;
import use_case.product.update.UpdateProductInputBoundary;
import use_case.product.update.UpdateProductInteractor;
import use_case.product.update.UpdateProductOutputBoundary;
import use_case.product.view.ViewProductInputBoundary;
import use_case.product.view.ViewProductInteractor;
import use_case.product.view.ViewProductOutputBoundary;
import use_case.user.auth.AuthInputBoundary;
import use_case.user.auth.AuthInteractor;
import use_case.user.auth.AuthOutputBoundary;
import use_case.user.reg.RegInputBoundary;
import use_case.user.reg.RegInteractor;
import use_case.user.reg.RegOutputBoundary;
import use_case.user.show_my_profile.ShowMyProfileInputBoundary;
import use_case.user.show_my_profile.ShowMyProfileInteractor;
import use_case.user.show_my_profile.ShowMyProfileOutputBoundary;
import use_case.user.show_other_profile.ShowOtherProfileInputBoundary;
import use_case.user.show_other_profile.ShowOtherProfileInteractor;
import use_case.user.show_other_profile.ShowOtherProfileOutputBoundary;
import use_case.user.show_wishlist.ShowWishlistInputBoundary;
import use_case.user.show_wishlist.ShowWishlistInteractor;
import use_case.user.show_wishlist.ShowWishlistOutputBoundary;
import use_case.user.update_my_profile.UpdateMyProfileInteractor;
import use_case.user.update_my_profile.UpdateMyProfileOutputBoundary;
import use_case.user.update_name.UpdateNameInteractor;
import use_case.user.update_name.UpdateNameOutputBoundary;
import use_case.user.update_pwd.UpdatePasswordInteractor;
import use_case.user.update_pwd.UpdatePasswordOutputBoundary;
import use_case.user.update_wishlist.UpdateWishlistInputBoundary;
import use_case.user.update_wishlist.UpdateWishlistInteractor;
import use_case.user.update_wishlist.UpdateWishlistOutputBoundary;
import view.book.BookView;
import view.book.SearchBookView;
import view.container.ViewManager;
import view.product.EditProductView;
import view.product.ListProductView;
import view.user.*;
import javax.swing.*;

public class MainWithAPI {

    public static void main(String[] args) {

        InMemoryUserDataAccessObject inMemoryUserDAO = new InMemoryUserDataAccessObject();
        InMemoryProductDataAccessObject inMemoryProductDataAccessObject = new InMemoryProductDataAccessObject();
        APIBookDataAccessObject apiBookDataAccessObject = new APIBookDataAccessObject();

        final ViewManagerModel viewManagerModel = new ViewManagerModel();
        final ViewManager viewManager = new ViewManager(viewManagerModel);
        viewManager.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        final AuthViewModel authViewModel = new AuthViewModel();
        final AuthOutputBoundary authPresenter = new AuthPresenter(viewManagerModel, authViewModel);
        final AuthInputBoundary authInteract = new AuthInteractor(inMemoryUserDAO, authPresenter);
        final AuthController authController = new AuthController(authInteract);
        final AuthView authView = new AuthView(viewManager, authViewModel, authController);

        final RegViewModel regViewModel = new RegViewModel();
        final RegOutputBoundary regPresenter = new RegPresenter(regViewModel, viewManagerModel);
        final RegInputBoundary regInteractor = new RegInteractor(inMemoryUserDAO, regPresenter);
        final RegController regController = new RegController(regInteractor);
        final RegView regView = new RegView(viewManager, regViewModel, regController);

        final ShowMyProfileViewModel showMyProfileViewModel = new ShowMyProfileViewModel();
        final ShowMyProfileOutputBoundary showMyProfilePresenter = new ShowMyProfilePresenter(showMyProfileViewModel, viewManagerModel);
        final ShowMyProfileInputBoundary showMyProfileInteractor = new ShowMyProfileInteractor(inMemoryUserDAO, showMyProfilePresenter);
        final ShowMyProfileController showMyProfileController = new ShowMyProfileController(showMyProfileInteractor, viewManagerModel);

        final UpdateMyProfileViewModel updateProfileViewModel = new UpdateMyProfileViewModel();
        final UpdateMyProfileOutputBoundary updateProfilePresenter = new UpdateMyProfilePresenter(updateProfileViewModel, showMyProfileViewModel);
        final UpdateMyProfileInteractor updateProfileInteractor = new UpdateMyProfileInteractor(inMemoryUserDAO, updateProfilePresenter);
        final UpdateMyProfileController updateProfileController = new UpdateMyProfileController(updateProfileInteractor, viewManagerModel);
        final UpdateProfileView updateProfileView = new UpdateProfileView(viewManager, updateProfileViewModel, updateProfileController);

        final UpdateNameViewModel updateNameViewModel = new UpdateNameViewModel();
        final UpdateNameOutputBoundary updateNamePresenter = new UpdateNamePresenter(updateNameViewModel, showMyProfileViewModel, viewManagerModel);
        final UpdateNameInteractor updateNameInteractor = new UpdateNameInteractor(inMemoryUserDAO, updateNamePresenter);
        final UpdateNameController updateNameController = new UpdateNameController(updateNameInteractor, viewManagerModel);
        final UpdateNameView updateNameView = new UpdateNameView(viewManager, updateNameViewModel, updateNameController);

        final ProfileView profileView = new ProfileView(showMyProfileViewModel, showMyProfileController, updateNameViewModel, updateProfileViewModel, viewManagerModel);

        final UpdatePasswordViewModel updatePasswordViewModel = new UpdatePasswordViewModel();
        final UpdatePasswordOutputBoundary updatePasswordPresenter = new UpdatePasswordPresenter(updatePasswordViewModel, viewManagerModel);
        final UpdatePasswordInteractor updatePasswordInteractor = new UpdatePasswordInteractor(inMemoryUserDAO, updatePasswordPresenter);
        final UpdatePasswordController updatePasswordController = new UpdatePasswordController(updatePasswordInteractor, viewManagerModel);
        final UpdatePwdView updatePwdView = new UpdatePwdView(viewManager, updatePasswordViewModel, updatePasswordController);

        final BookViewModel bookViewModel = new BookViewModel();
        final ViewBookOutputBoundary viewBookPresenter = new BookPresenter(bookViewModel, viewManagerModel);
        final ViewBookInputBoundary viewBookInteractor = new ViewBookInteractor(apiBookDataAccessObject, viewBookPresenter);
        final BookController bookController = new BookController(viewBookInteractor);

        final ShowOtherProfileViewModel showOtherProfileViewModel = new ShowOtherProfileViewModel();
        final ShowOtherProfileOutputBoundary showOtherProfilePresenter = new ShowOtherProfilePresenter(showOtherProfileViewModel);
        final ShowOtherProfileInputBoundary showOtherProfileInteractor = new ShowOtherProfileInteractor(inMemoryUserDAO, showOtherProfilePresenter);
        final ShowOtherProfileController showOtherProfileController = new ShowOtherProfileController(showOtherProfileInteractor);

        final ProductViewModel productViewModel = new ProductViewModel();
        final ViewProductOutputBoundary productPresenter = new ProductPresenter(productViewModel, bookViewModel, showOtherProfileViewModel);
        final ViewProductInputBoundary viewProductInteractor = new ViewProductInteractor(inMemoryProductDataAccessObject, productPresenter);
        final ProductController productController = new ProductController(viewProductInteractor);

        final ListBookProductViewModel listBookProductViewModel = new ListBookProductViewModel();
        final ListBookProductOutputBoundary listBookProductPresenter = new ListBookProductPresenter(listBookProductViewModel);
        final ListBookProductInputBoundary listBookProductInteractor = new ListBookProductInteractor(apiBookDataAccessObject, inMemoryProductDataAccessObject, listBookProductPresenter);
        final ListBookProductController listBookProductController = new ListBookProductController(listBookProductInteractor);

        final UpdateProductViewModel updateProductViewModel = new UpdateProductViewModel();
        final UpdateProductOutputBoundary updateProductPresenter = new UpdateProductPresenter(updateProductViewModel, productViewModel);
        final UpdateProductInputBoundary updateProductInteractor = new UpdateProductInteractor(inMemoryUserDAO, apiBookDataAccessObject, inMemoryProductDataAccessObject, updateProductPresenter);
        final CreateProductPresenter createProductPresenter = new CreateProductPresenter(updateProductViewModel, productViewModel);
        final CreateProductInputBoundary createProductInteractor = new CreateProductInteractor(inMemoryUserDAO, inMemoryProductDataAccessObject, createProductPresenter);
        final UpdateProductController updateProductController = new UpdateProductController(updateProductInteractor, createProductInteractor, viewManagerModel);
        final EditProductView updateProductView = new EditProductView(
                updateProductViewModel, updateProductController, bookViewModel, bookController, productViewModel, productController);

        final ListMyProductViewModel listMyProductViewModel = new ListMyProductViewModel();
        final ListMyProductOutputBoundary listMyProductPresenter = new ListMyProductPresenter(listMyProductViewModel);
        final ListMyProductInputBoundary listMyProductInteractor = new ListMyProductInteractor(inMemoryUserDAO, inMemoryProductDataAccessObject, listMyProductPresenter);
        final ListMyProductController listMyProductController = new ListMyProductController(listMyProductInteractor, viewManagerModel);

        final RemoveProductViewModel removeProductViewModel = new RemoveProductViewModel();
        final RemoveProductOutputBoundary removeProductPresenter = new RemoveProductPresenter(removeProductViewModel, listMyProductViewModel);
        final RemoveProductInputBoundary removeProductInteractor = new RemoveProductInteractor(inMemoryUserDAO, inMemoryProductDataAccessObject, removeProductPresenter);
        final RemoveProductController removeProductController = new RemoveProductController(removeProductInteractor, viewManagerModel);

        final ListProductView listProductView = new ListProductView(listMyProductViewModel, listMyProductController, removeProductViewModel, removeProductController, updateProductViewModel, viewManagerModel);

        final ShowWishlistViewModel showWishlistViewModel = new ShowWishlistViewModel();
        final ShowWishlistOutputBoundary showWishlistPresenter = new ShowWishlistPresenter(showWishlistViewModel, viewManagerModel);
        final ShowWishlistInputBoundary showWishlistInteractor = new ShowWishlistInteractor(inMemoryUserDAO, showWishlistPresenter);
        final ShowWishlistController showWishlistController = new ShowWishlistController(showWishlistInteractor, viewManagerModel);

        final UpdateWishlistViewModel updateWishlistViewModel = new UpdateWishlistViewModel();
        final UpdateWishlistOutputBoundary updateWishlistPresenter = new UpdateWishlistPresenter(updateWishlistViewModel, showWishlistViewModel);
        final UpdateWishlistInputBoundary updateWishlistInteractor = new UpdateWishlistInteractor(inMemoryUserDAO, updateWishlistPresenter);
        final UpdateWishlistController updateWishlistController = new UpdateWishlistController(updateWishlistInteractor, viewManagerModel);
        final WishlistView wishlistView = new WishlistView(showWishlistViewModel, showWishlistController, updateWishlistViewModel, updateWishlistController, productViewModel, productController, bookController, viewManagerModel);


        final BookView bookView = new BookView(
                bookViewModel, productViewModel, productController, showOtherProfileViewModel, showOtherProfileController,
                listBookProductViewModel, listBookProductController, showWishlistViewModel, showWishlistController,
                updateWishlistViewModel, updateWishlistController, viewManagerModel);

        final SearchBookViewModel searchBookViewModel = new SearchBookViewModel();
        final SearchBookOutputBoundary searchBookPresenter = new SearchBookPresenter(searchBookViewModel, viewManagerModel);
        final SearchBookInputBoundary searchBookInteractor = new SearchBookInteractor(inMemoryProductDataAccessObject, apiBookDataAccessObject, searchBookPresenter);
        final SearchBookController searchBookController = new SearchBookController(searchBookInteractor);
        final SearchBookView searchBookView = new SearchBookView(searchBookViewModel, searchBookController, bookViewModel, bookController, viewManagerModel);

        viewManager.setViews(
                authView, regView, updateNameView, updateProfileView, updatePwdView, updateProductView, profileView,
                wishlistView, listProductView, searchBookView, bookView);


        ViewManagerState state = viewManagerModel.getState();
        state.setViewName("search book");
        viewManagerModel.firePropertyChanged();

        viewManager.pack();
        viewManager.setVisible(true);

    }
}
