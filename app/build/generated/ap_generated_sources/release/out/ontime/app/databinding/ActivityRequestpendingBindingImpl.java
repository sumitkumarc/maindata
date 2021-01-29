package ontime.app.databinding;
import ontime.app.R;
import ontime.app.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityRequestpendingBindingImpl extends ActivityRequestpendingBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rly, 1);
        sViewsWithIds.put(R.id.back, 2);
        sViewsWithIds.put(R.id.lllist, 3);
        sViewsWithIds.put(R.id.second, 4);
        sViewsWithIds.put(R.id.txt_name, 5);
        sViewsWithIds.put(R.id.txt_total, 6);
        sViewsWithIds.put(R.id.txt_order_status, 7);
        sViewsWithIds.put(R.id.txt_qty, 8);
        sViewsWithIds.put(R.id.txt_hfirst, 9);
        sViewsWithIds.put(R.id.txt_hfsecond, 10);
        sViewsWithIds.put(R.id.txt_mfirst, 11);
        sViewsWithIds.put(R.id.txt_mSecond, 12);
        sViewsWithIds.put(R.id.txt_sFirst, 13);
        sViewsWithIds.put(R.id.txt_sSecond, 14);
        sViewsWithIds.put(R.id.llbotom, 15);
        sViewsWithIds.put(R.id.bt_cancel, 16);
        sViewsWithIds.put(R.id.bt_pay_now, 17);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityRequestpendingBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }
    private ActivityRequestpendingBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.Button) bindings[16]
            , (android.widget.Button) bindings[17]
            , (android.widget.LinearLayout) bindings[15]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.RelativeLayout) bindings[1]
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[6]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
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