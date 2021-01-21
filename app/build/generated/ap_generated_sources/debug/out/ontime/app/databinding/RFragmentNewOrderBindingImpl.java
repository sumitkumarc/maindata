package ontime.app.databinding;
import ontime.app.R;
import ontime.app.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class RFragmentNewOrderBindingImpl extends RFragmentNewOrderBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.fl_details, 1);
        sViewsWithIds.put(R.id.iv_user_name, 2);
        sViewsWithIds.put(R.id.txt_user_name, 3);
        sViewsWithIds.put(R.id.iv_order_item, 4);
        sViewsWithIds.put(R.id.txt_order_item, 5);
        sViewsWithIds.put(R.id.txt_order_Qty, 6);
        sViewsWithIds.put(R.id.txt_order_status, 7);
        sViewsWithIds.put(R.id.txt_order_pamnet_type, 8);
        sViewsWithIds.put(R.id.txt_order_date, 9);
        sViewsWithIds.put(R.id.txt_order_id, 10);
        sViewsWithIds.put(R.id.txt_order_time, 11);
        sViewsWithIds.put(R.id.txt_order_deliver_type, 12);
        sViewsWithIds.put(R.id.txt_total, 13);
        sViewsWithIds.put(R.id.txt_tax, 14);
        sViewsWithIds.put(R.id.bt_confirm, 15);
        sViewsWithIds.put(R.id.bt_cancelled, 16);
        sViewsWithIds.put(R.id.fl_time, 17);
        sViewsWithIds.put(R.id.bt_timer_confirm, 18);
        sViewsWithIds.put(R.id.txt_no_data, 19);
        sViewsWithIds.put(R.id.rv_details, 20);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public RFragmentNewOrderBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 21, sIncludes, sViewsWithIds));
    }
    private RFragmentNewOrderBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatButton) bindings[16]
            , (androidx.appcompat.widget.AppCompatButton) bindings[15]
            , (androidx.appcompat.widget.AppCompatButton) bindings[18]
            , (android.widget.LinearLayout) bindings[0]
            , (android.widget.FrameLayout) bindings[1]
            , (android.widget.FrameLayout) bindings[17]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.ImageView) bindings[2]
            , (androidx.recyclerview.widget.RecyclerView) bindings[20]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[3]
            );
        this.constraintLayout.setTag(null);
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