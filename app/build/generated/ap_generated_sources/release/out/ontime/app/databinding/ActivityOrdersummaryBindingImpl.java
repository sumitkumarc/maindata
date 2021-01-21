package ontime.app.databinding;
import ontime.app.R;
import ontime.app.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityOrdersummaryBindingImpl extends ActivityOrdersummaryBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rly, 1);
        sViewsWithIds.put(R.id.ll_toolbar, 2);
        sViewsWithIds.put(R.id.ll_back, 3);
        sViewsWithIds.put(R.id.iv_back_arrow, 4);
        sViewsWithIds.put(R.id.ll_main, 5);
        sViewsWithIds.put(R.id.fist, 6);
        sViewsWithIds.put(R.id.iv_rest_profile_img, 7);
        sViewsWithIds.put(R.id.second, 8);
        sViewsWithIds.put(R.id.txt_Name, 9);
        sViewsWithIds.put(R.id.txt_price, 10);
        sViewsWithIds.put(R.id.txt_Address, 11);
        sViewsWithIds.put(R.id.ll_delete_item, 12);
        sViewsWithIds.put(R.id.rv_list, 13);
        sViewsWithIds.put(R.id.txt_date, 14);
        sViewsWithIds.put(R.id.txt_wallet, 15);
        sViewsWithIds.put(R.id.rvPaymnetMethordList, 16);
        sViewsWithIds.put(R.id.checkBox, 17);
        sViewsWithIds.put(R.id.txt_grand_total, 18);
        sViewsWithIds.put(R.id.txt_additional_item, 19);
        sViewsWithIds.put(R.id.txt_order_total, 20);
        sViewsWithIds.put(R.id.txt_discount, 21);
        sViewsWithIds.put(R.id.txt_pay_amount, 22);
        sViewsWithIds.put(R.id.llbotom, 23);
        sViewsWithIds.put(R.id.bt_apply, 24);
        sViewsWithIds.put(R.id.ed_CouponCode, 25);
        sViewsWithIds.put(R.id.bt_send_request, 26);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityOrdersummaryBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 27, sIncludes, sViewsWithIds));
    }
    private ActivityOrdersummaryBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatButton) bindings[24]
            , (androidx.appcompat.widget.AppCompatButton) bindings[26]
            , (android.widget.CheckBox) bindings[17]
            , (android.widget.EditText) bindings[25]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.ImageView) bindings[4]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[7]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.LinearLayout) bindings[12]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.LinearLayout) bindings[23]
            , (android.widget.LinearLayout) bindings[1]
            , (androidx.recyclerview.widget.RecyclerView) bindings[13]
            , (androidx.recyclerview.widget.RecyclerView) bindings[16]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[21]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[15]
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