package eu.acsone.client.application.home.tab;

import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class SubTab2View extends ViewImpl implements SubTab2Presenter.MyView {

 HTMLPanel content;
    
  @Inject
  public SubTab2View() {
    content = new HTMLPanel("nested sub tab 2 lorem ipsum");
  }
  
    @Override
  public Widget asWidget() {
    return content;
  }

}
