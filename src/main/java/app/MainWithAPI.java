package app;

import data_access.user.InMemoryUserDataAccessObject;
import interface_adapter.container.ViewManagerModel;
import interface_adapter.user.auth.AuthController;
import interface_adapter.user.auth.AuthPresenter;
import interface_adapter.user.auth.AuthViewModel;
import interface_adapter.user.reg.RegController;
import interface_adapter.user.reg.RegPresenter;
import interface_adapter.user.reg.RegViewModel;
import interface_adapter.user.show_my_profile.ShowMyProfileViewModel;
import interface_adapter.user.update_my_profile.UpdateMyProfileController;
import interface_adapter.user.update_my_profile.UpdateMyProfilePresenter;
import interface_adapter.user.update_my_profile.UpdateMyProfileViewModel;
import interface_adapter.user.update_name.UpdateNameController;
import interface_adapter.user.update_name.UpdateNamePresenter;
import interface_adapter.user.update_name.UpdateNameViewModel;
import interface_adapter.user.update_pwd.UpdatePasswordController;
import interface_adapter.user.update_pwd.UpdatePasswordPresenter;
import interface_adapter.user.update_pwd.UpdatePasswordViewModel;
import use_case.user.auth.AuthInputBoundary;
import use_case.user.auth.AuthInteractor;
import use_case.user.auth.AuthOutputBoundary;
import use_case.user.reg.RegInputBoundary;
import use_case.user.reg.RegInteractor;
import use_case.user.reg.RegOutputBoundary;
import use_case.user.update_my_profile.UpdateMyProfileInteractor;
import use_case.user.update_my_profile.UpdateMyProfileOutputBoundary;
import use_case.user.update_name.UpdateNameInteractor;
import use_case.user.update_name.UpdateNameOutputBoundary;
import use_case.user.update_pwd.UpdatePasswordInteractor;
import use_case.user.update_pwd.UpdatePasswordOutputBoundary;
import view.container.ViewManager;
import view.user.*;

public class MainWithAPI {

    public static void main(String[] args) {

        InMemoryUserDataAccessObject inMemoryUserDAO = new InMemoryUserDataAccessObject();

        final ViewManagerModel viewManagerModel = new ViewManagerModel();
        final ViewManager viewManager = new ViewManager(viewManagerModel);

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
        final UpdateNameViewModel updateNameViewModel = new UpdateNameViewModel();
        final UpdateNameOutputBoundary updateNamePresenter = new UpdateNamePresenter(updateNameViewModel, showMyProfileViewModel, viewManagerModel);
        final UpdateNameInteractor updateNameInteractor = new UpdateNameInteractor(inMemoryUserDAO, updateNamePresenter);
        final UpdateNameController updateNameController = new UpdateNameController(updateNameInteractor, viewManagerModel);
        final UpdateNameView updateNameView = new UpdateNameView(viewManager, updateNameViewModel, updateNameController);

        final UpdatePasswordViewModel updatePasswordViewModel = new UpdatePasswordViewModel();
        final UpdatePasswordOutputBoundary updatePasswordPresenter = new UpdatePasswordPresenter(updatePasswordViewModel, viewManagerModel);
        final UpdatePasswordInteractor updatePasswordInteractor = new UpdatePasswordInteractor(inMemoryUserDAO, updatePasswordPresenter);
        final UpdatePasswordController updatePasswordController = new UpdatePasswordController(updatePasswordInteractor, viewManagerModel);
        final UpdatePwdView updatePwdView = new UpdatePwdView(viewManager, updatePasswordViewModel, updatePasswordController);


        final UpdateMyProfileViewModel updateProfileViewModel = new UpdateMyProfileViewModel();
        final UpdateMyProfileOutputBoundary updateProfilePresenter = new UpdateMyProfilePresenter(updateProfileViewModel, showMyProfileViewModel);
        final UpdateMyProfileInteractor updateProfileInteractor = new UpdateMyProfileInteractor(inMemoryUserDAO, updateProfilePresenter);
        final UpdateMyProfileController updateProfileController = new UpdateMyProfileController(updateProfileInteractor, viewManagerModel);
        final UpdateProfileView updateProfileView = new UpdateProfileView(viewManager, updateProfileViewModel, updateProfileController);

        

    }
}
