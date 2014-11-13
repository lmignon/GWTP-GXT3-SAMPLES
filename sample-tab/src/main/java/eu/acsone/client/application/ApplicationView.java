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
