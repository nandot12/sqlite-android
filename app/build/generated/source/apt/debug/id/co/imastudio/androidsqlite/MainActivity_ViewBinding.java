// Generated code from Butter Knife. Do not modify!
package id.co.imastudio.androidsqlite;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131165219;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.etMkanan = Utils.findRequiredViewAsType(source, R.id.etMkanan, "field 'etMkanan'", EditText.class);
    target.etPrice = Utils.findRequiredViewAsType(source, R.id.etPrice, "field 'etPrice'", EditText.class);
    target.etRestoran = Utils.findRequiredViewAsType(source, R.id.etRestoran, "field 'etRestoran'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btnSubmit, "field 'btnSubmit' and method 'onViewClicked'");
    target.btnSubmit = Utils.castView(view, R.id.btnSubmit, "field 'btnSubmit'", Button.class);
    view2131165219 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.literecycler = Utils.findRequiredViewAsType(source, R.id.literecycler, "field 'literecycler'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etMkanan = null;
    target.etPrice = null;
    target.etRestoran = null;
    target.btnSubmit = null;
    target.literecycler = null;

    view2131165219.setOnClickListener(null);
    view2131165219 = null;
  }
}
