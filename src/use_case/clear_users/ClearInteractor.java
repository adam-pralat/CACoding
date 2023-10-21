package use_case.clear_users;


public class ClearInteractor implements ClearInputBoundary {
    final ClearUserDataAccessInterface userDataAccessObject;
    final ClearOutputBoundary clearPresenter;

    public ClearInteractor(ClearUserDataAccessInterface userDataAccessObject,
                           ClearOutputBoundary clearOutputBoundary) {
        this.userDataAccessObject = userDataAccessObject;
        this.clearPresenter = clearOutputBoundary;
    }

    @Override
    public void execute(ClearInputData inputData) {
        try {
            String[] deletedUsers = userDataAccessObject.deleteUsers();
            clearPresenter.prepareSuccessView(new ClearOutputData(deletedUsers, true));
        } catch (Exception e) {
            clearPresenter.prepareFailView(e.toString());
        }
    }
}
