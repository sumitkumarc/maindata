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
        sViewsWithIds.put(R.id.addtocart, 3);
        sViewsWithIds.put(R.id.ll_main, 4);
        sViewsWithIds.put(R.id.iv_pro_image, 5);
        sViewsWithIds.put(R.id.txt_pro_name, 6);
        sViewsWithIds.put(R.id.txt_pro_dsc, 7);
        sViewsWithIds.put(R.id.ll_details, 8);
        sViewsWithIds.put(R.id.txt_pro_calories, 9);
        sViewsWithIds.put(R.id.txt_calories, 10);
        sViewsWithIds.put(R.id.txt_pro_size, 11);
        sViewsWithIds.put(R.id.rgCD, 12);
        sViewsWithIds.put(R.id.txt_addition, 13);
        sViewsWithIds.put(R.id.rgCDs, 14);
        sViewsWithIds.put(R.id.txt_pro_removal, 15);
        sViewsWithIds.put(R.id.rgCDss, 16);
        sViewsWithIds.put(R.id.ed_notes, 17);
        sViewsWithIds.put(R.id.llbotom, 18);
        sViewsWithIds.put(R.id.txt_pro_price, 19);
        sViewsWithIds.put(R.id.txt_qty, 20);
        sViewsWithIds.put(R.id.iv_add, 21);
        sViewsWithIds.put(R.id.iv_sub, 22);
        sViewsWithIds.put(R.id.bt_addtocart, 23);
    }
    // views
    @NonNull
    private final androidx.appcompat.widget.LinearLayoutCompat mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityRestdetailBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 24, sIncludes, sViewsWithIds));
    }
    private ActivityRestdetailBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.FrameLayout) bindings[3]
            , (android.widget.LinearLayout) bindings[2]
            , (androidx.appcompat.widget.AppCompatButton) bindings[23]
            , (android.widget.EditText) bindings[17]
            , (android.widget.ImageView) bindings[21]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageView) bindings[22]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.LinearLayout) bindings[18]
            , (android.widget.RadioGroup) bindings[12]
            , (android.widget.RadioGroup) bindings[14]
            , (android.widget.RadioGroup) bindings[16]
            , (android.widget.RelativeLayout) bindings[1]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[20]
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