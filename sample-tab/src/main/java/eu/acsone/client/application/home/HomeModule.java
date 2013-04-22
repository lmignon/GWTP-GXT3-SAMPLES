package eu.acsone.client.application.home;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

import eu.acsone.client.application.home.tab.HomeTab1Presenter;
import eu.acsone.client.application.home.tab.HomeTab1View;
import eu.acsone.client.application.home.tab.HomeTab2Presenter;
import eu.acsone.client.application.home.tab.HomeTab2View;

public class HomeModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(HomePagePresenter.class, HomePagePresenter.MyView.class, HomePageView.class,
                HomePagePresenter.MyProxy.class);
        bindPresenter(HomeTab1Presenter.class, HomeTab1Presenter.MyView.class, HomeTab1View.class,
                HomeTab1Presenter.MyProxy.class);
        bindPresenter(HomeTab2Presenter.class, HomeTab2Presenter.MyView.class, HomeTab2View.class,
                HomeTab2Presenter.MyProxy.class);
    }
}
