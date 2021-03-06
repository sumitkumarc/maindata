package ontime.app.databinding;
import ontime.app.R;
import ontime.app.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityRestdetailBindingImpl extends ActivityRestdetailBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rly, 1);
        sViewsWithIds.put(R.id.back, 2);
        sViewsWithIds.put(R.id.fl_addtocart, 3);
        sViewsWithIds.put(R.id.txt_count, 4);
        sViewsWithIds.put(R.id.iv_addtocart, 5);
        sViewsWithIds.put(R.id.ll_main, 6);
        sViewsWithIds.put(R.id.iv_pro_image, 7);
        sViewsWithIds.put(R.id.txt_pro_name, 8);
        sViewsWithIds.put(R.id.txt_pro_dsc, 9);
        sViewsWithIds.put(R.id.ll_details, 10);
        sViewsWithIds.put(R.id.txt_pro_calories, 11);
        sViewsWithIds.put(R.id.txt_calories, 12);
        sViewsWithIds.put(R.id.txt_pro_size, 13);
        sViewsWithIds.put(R.id.rgCD, 14);
        sViewsWithIds.put(R.id.txt_addition, 15);
        sViewsWithIds.put(R.id.rgCDs, 16);
        sViewsWithIds.put(R.id.txt_pro_removal, 17);
        sViewsWithIds.put(R.id.rgCDss, 18);
        sViewsWithIds.put(R.id.ed_notes, 19);
        sViewsWithIds.put(R.id.llbotom, 20);
        sViewsWithIds.put(R.id.txt_pro_price, 21);
        sViewsWithIds.put(R.id.txt_qty, 22);
        sViewsWithIds.put(R.id.iv_add, 23);
        sViewsWithIds.put(R.id.iv_sub, 24);
        sViewsWithIds.put(R.id.bt_addtocart, 25);
    }
    // views
    @NonNull
    private final androidx.appcompat.widget.LinearLayoutCompat mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityRestdetailBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 26, sIncludes, sViewsWithIds));
    }
    private ActivityRestdetailBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[2]
            , (androidx.appcompat.widget.AppCompatButton) bindings[25]
            , (android.widget.EditText) bindings[19]
            , (android.widget.FrameLayout) bindings[3]
            , (android.widget.ImageView) bindings[23]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.ImageView) bindings[24]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.LinearLayout) bindings[20]
            , (android.widget.RadioGroup) bindings[14]
            , (android.widget.RadioGroup) bindings[16]
            , (android.widget.RadioGroup) bindings[18]
            , (android.widget.RelativeLayout) bindings[1]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[21]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[22]
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