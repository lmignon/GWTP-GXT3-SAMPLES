/**
 *    Authors: Laurent Mignon
 *    Copyright (c) 2012 Acsone SA/NV (http://www.acsone.eu)
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU Affero General Public License as
 *    published by the Free Software Foundation, either version 3 of the
 *    License, or (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU Affero General Public License for more details.
 *
 *    You should have received a copy of the GNU Affero General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package eu.acsone.client.application.home.tab;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.annotations.TabInfo;
import com.gwtplatform.mvp.client.proxy.TabContentProxyPlace;

import eu.acsone.client.place.NameTokens;

public class SubTab2Presenter extends
		Presenter<SubTab2Presenter.MyView, SubTab2Presenter.MyProxy> {

	private final DispatchAsync dispatchAsync;

	@NameToken(NameTokens.nested2)
	@ProxyStandard
	@TabInfo(container = HomeTab2Presenter.class, priority = 1, label = "sub tab2")
	public interface MyProxy extends TabContentProxyPlace<SubTab2Presenter> {
	}

	public interface MyView extends View {
	}

	@Inject
	public SubTab2Presenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy, final DispatchAsync dispatchAsync) {
		super(eventBus, view, proxy, HomeTab2Presenter.TYPE_SetTabContent);
		this.dispatchAsync = dispatchAsync;
	}
}
