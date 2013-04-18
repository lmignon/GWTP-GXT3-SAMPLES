/**
 * Copyright 2012 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

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
