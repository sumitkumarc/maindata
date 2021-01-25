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
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(15);
        sIncludes.setIncludes(1, 
            new String[] {"c_row_requestpending_item"},
            new int[] {2},
            new int[] {ontime.app.R.layout.c_row_requestpending_item});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rly, 3);
        sViewsWithIds.put(R.id.back, 4);
        sViewsWithIds.put(R.id.rv_list, 5);
        sViewsWithIds.put(R.id.txt_hfirst, 6);
        sViewsWithIds.put(R.id.txt_hfsecond, 7);
        sViewsWithIds.put(R.id.txt_mfirst, 8);
        sViewsWithIds.put(R.id.txt_mSecond, 9);
        sViewsWithIds.put(R.id.txt_sFirst, 10);
        sViewsWithIds.put(R.id.txt_sSecond, 11);
        sViewsWithIds.put(R.id.llbotom, 12);
        sViewsWithIds.put(R.id.bt_cancel, 13);
        sViewsWithIds.put(R.id.bt_pay_now, 14);
    }
    // views
    @NonNull
    private final androidx.appcompat.widget.LinearLayoutCompat mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView1;
    @Nullable
    private final ontime.app.databinding.CRowRequestpendingItemBinding mboundView11;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityRequestpendingBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }
    private ActivityRequestpendingBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.Button) bindings[13]
            , (android.widget.Button) bindings[14]
            , (android.widget.LinearLayout) bindings[12]
            , (android.widget.RelativeLayout) bindings[3]
            , (androidx.recyclerview.widget.RecyclerView) bindings[5]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[11]
            );
        this.mboundView0 = (androidx.appcompat.widget.LinearLayoutCompat) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.LinearLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView11 = (ontime.app.databinding.CRowRequestpendingItemBinding) bindings[2];
        setContainedBinding(this.mboundView11);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        mboundView11.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (mboundView11.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        mboundView11.setLifecycleOwner(lifecycleOwner);
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
        executeBindingsOn(mboundView11);
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