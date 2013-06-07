package eu.acsone.client.application.home;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

import eu.acsone.client.application.home.tab.HomeTab1Presenter;
import eu.acsone.client.application.home.tab.HomeTab1View;
import eu.acsone.client.application.home.tab.HomeTab2Presenter;
import eu.acsone.client.application.home.tab.HomeTab2View;
import eu.acsone.client.application.home.tab.SubTab1Presenter;
import eu.acsone.client.application.home.tab.SubTab1View;
import eu.acsone.client.application.home.tab.SubTab2Presenter;
import eu.acsone.client.application.home.tab.SubTab2View;

public class HomeModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(HomePagePresenter.class, HomePagePresenter.MyView.class, HomePageView.class,
                HomePagePresenter.MyProxy.class);
        bindPresenter(HomeTab1Presenter.class, HomeTab1Presenter.MyView.class, HomeTab1View.class,
                HomeTab1Presenter.MyProxy.class);
        bindPresenter(HomeTab2Presenter.class, HomeTab2Presenter.MyView.class, HomeTab2View.class,
                HomeTab2Presenter.MyProxy.class);
        bindPresenter(SubTab1Presenter.class, SubTab1Presenter.MyView.class, SubTab1View.class,
                SubTab1Presenter.MyProxy.class);
        bindPresenter(SubTab2Presenter.class, SubTab2Presenter.MyView.class, SubTab2View.class,
                SubTab2Presenter.MyProxy.class);
        
    }
}
