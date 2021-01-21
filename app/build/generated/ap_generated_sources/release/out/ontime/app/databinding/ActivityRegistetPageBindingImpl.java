package ontime.app.databinding;
import ontime.app.R;
import ontime.app.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityRegistetPageBindingImpl extends ActivityRegistetPageBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.back, 1);
        sViewsWithIds.put(R.id.txt, 2);
        sViewsWithIds.put(R.id.cv_uploadimage, 3);
        sViewsWithIds.put(R.id.iv_user_profile, 4);
        sViewsWithIds.put(R.id.fl_update_profile, 5);
        sViewsWithIds.put(R.id.ed_fullname, 6);
        sViewsWithIds.put(R.id.ll_cc, 7);
        sViewsWithIds.put(R.id.flag_imv, 8);
        sViewsWithIds.put(R.id.etCountryCode, 9);
        sViewsWithIds.put(R.id.ed_phone_no, 10);
        sViewsWithIds.put(R.id.ed_address, 11);
        sViewsWithIds.put(R.id.ed_email_id, 12);
        sViewsWithIds.put(R.id.prefix, 13);
        sViewsWithIds.put(R.id.ed_password, 14);
        sViewsWithIds.put(R.id.register_btn, 15);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityRegistetPageBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private ActivityRegistetPageBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[1]
            , (androidx.cardview.widget.CardView) bindings[3]
            , (android.widget.EditText) bindings[11]
            , (android.widget.EditText) bindings[12]
            , (android.widget.EditText) bindings[6]
            , (android.widget.EditText) bindings[14]
            , (android.widget.EditText) bindings[10]
            , (android.widget.EditText) bindings[9]
            , (android.widget.FrameLayout) bindings[5]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.TextView) bindings[13]
            , (android.widget.RelativeLayout) bindings[0]
            , (androidx.appcompat.widget.AppCompatButton) bindings[15]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[2]
            );
        this.realitve.setTag(null);
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