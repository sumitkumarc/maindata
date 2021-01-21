package ontime.app.databinding;
import ontime.app.R;
import ontime.app.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityProfileBindingImpl extends ActivityProfileBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.ll_toolbar, 1);
        sViewsWithIds.put(R.id.back, 2);
        sViewsWithIds.put(R.id.iv_back_arrow, 3);
        sViewsWithIds.put(R.id.txt_edit, 4);
        sViewsWithIds.put(R.id.ll_main, 5);
        sViewsWithIds.put(R.id.rl_profile, 6);
        sViewsWithIds.put(R.id.fl_update_profile, 7);
        sViewsWithIds.put(R.id.iv_user_profile, 8);
        sViewsWithIds.put(R.id.ed_name, 9);
        sViewsWithIds.put(R.id.ed_phone_no, 10);
        sViewsWithIds.put(R.id.txt_sign_out, 11);
        sViewsWithIds.put(R.id.ll_order, 12);
        sViewsWithIds.put(R.id.txt_order, 13);
        sViewsWithIds.put(R.id.ll_cancelled, 14);
        sViewsWithIds.put(R.id.txt_cancelled, 15);
        sViewsWithIds.put(R.id.ll_total_spendes, 16);
        sViewsWithIds.put(R.id.txt_total_spend, 17);
    }
    // views
    @NonNull
    private final androidx.appcompat.widget.LinearLayoutCompat mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityProfileBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }
    private ActivityProfileBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.EditText) bindings[9]
            , (android.widget.EditText) bindings[10]
            , (androidx.cardview.widget.CardView) bindings[7]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.LinearLayout) bindings[14]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.LinearLayout) bindings[12]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.LinearLayout) bindings[16]
            , (android.widget.RelativeLayout) bindings[6]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[17]
            );
        this.mboundView0 = (androidx.appcompat.widget.LinearLayoutCompat) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}