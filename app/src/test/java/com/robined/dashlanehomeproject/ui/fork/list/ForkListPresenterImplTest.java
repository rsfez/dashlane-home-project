package com.robined.dashlanehomeproject.ui.fork.list;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.robined.dashlanehomeproject.data.fork.entities.Fork;
import com.robined.dashlanehomeproject.data.fork.entities.ForkOwner;
import com.robined.dashlanehomeproject.data.fork.interactor.ForkInteractor;
import com.robined.dashlanehomeproject.ui.fork.list.contracts.ForkListView;
import com.robined.dashlanehomeproject.ui.fork.list.contracts.ForkRowView;
import io.reactivex.disposables.Disposable;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ForkListPresenterImplTest {

    @Mock private ForkInteractor mForkInteractor;
    @Mock private ForkListView mForkListView;

    private ForkListPresenterImpl mForkListPresenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mForkListPresenter = new ForkListPresenterImpl(mForkInteractor, mForkListView);
    }

    @Test
    public void getForkList() {
        mForkListPresenter.getForkList();

        verify(mForkListView).setLoadingState(true);
        verify(mForkInteractor).getForkList("DefinitelyTyped", "", mForkListPresenter);
    }

    @Test
    public void searchFork() {
        CharSequence query = "searchQuery";
        mForkListPresenter.searchFork(query);

        verify(mForkListView).setLoadingState(true);
        verify(mForkInteractor).getForkList("DefinitelyTyped", query, mForkListPresenter);
    }

    @Test
    public void getForkCount() {
        List<Fork> mockForkList = Arrays.asList(mock(Fork.class), mock(Fork.class));

        mForkListPresenter.onForkListFetchedSuccess(mockForkList);

        assertEquals(2, mForkListPresenter.getForkCount());
    }

    @Test
    public void onBindForkViewHolderAtPosition() {
        ForkRowView mockForkRowView = mock(ForkRowView.class);
        Fork fork = new Fork();
        ForkOwner forkOwner = new ForkOwner();
        final String login = "John";
        final String avatarUrl = "https://test.org/pic.png";
        forkOwner.mLogin = login;
        forkOwner.mAvatarUrl = avatarUrl;
        fork.mOwner = forkOwner;
        List<Fork> mockForkList = Arrays.asList(mock(Fork.class), fork);
        mForkListPresenter.onForkListFetchedSuccess(mockForkList);

        mForkListPresenter.onBindForkViewHolderAtPosition(1, mockForkRowView);

        verify(mockForkRowView).setOwnerName(login);
        verify(mockForkRowView).displayPictureFromUrl(avatarUrl);
    }

    @Test
    public void unsubscribe() {
        assertFalse(mForkListPresenter.mCompositeDisposable.isDisposed());

        mForkListPresenter.unsubscribe();

        assertTrue(mForkListPresenter.mCompositeDisposable.isDisposed());
    }

    @Test
    public void onSubscribe() {
        Disposable disposable = mock(Disposable.class);

        mForkListPresenter.onSubscribe(disposable);

        assertEquals(1, mForkListPresenter.mCompositeDisposable.size());
    }

    @Test
    public void onForkListFetchedSuccess() {
        List<Fork> mockForkList = Arrays.asList(mock(Fork.class), mock(Fork.class));

        mForkListPresenter.onForkListFetchedSuccess(mockForkList);

        for(int i = 0; i < mockForkList.size(); i++) {
            assertEquals(mockForkList.get(i), mForkListPresenter.mForkList.get(i));
        }

        verify(mForkListView).onDataReady();
        verify(mForkListView).setLoadingState(false);
    }

    @Test
    public void onForkListFetchedError() {
        mForkListPresenter.onForkListFetchedError();

        verify(mForkListView).showError();
        verify(mForkListView).setLoadingState(false);
    }
}