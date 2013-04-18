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

package eu.acsone.client.application;

import javax.inject.Inject;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class ApplicationView extends ViewImpl implements
		ApplicationPresenter.MyView {

	private ViewPanels viewPanels;

	@Inject
	public ApplicationView() {
		viewPanels = new ViewPanels();
	}

	@Override
	public Widget asWidget() {
		return viewPanels.getViewport();
	}

	@Override
	public void setInSlot(Object slot, IsWidget content) {
		if (slot == ApplicationPresenter.SLOT_content) {
			if (content != null) {

				viewPanels.getCenterPanel().clear();
				viewPanels.getCenterPanel().add(content);
				viewPanels.getCenterPanel().forceLayout();
			}
		} else {
			super.setInSlot(slot, content);
		}
	}
}
