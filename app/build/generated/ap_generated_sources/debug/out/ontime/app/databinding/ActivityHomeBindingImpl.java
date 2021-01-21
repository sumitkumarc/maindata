package ontime.app.databinding;
import ontime.app.R;
import ontime.app.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityHomeBindingImpl extends ActivityHomeBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rly, 1);
        sViewsWithIds.put(R.id.menu, 2);
        sViewsWithIds.put(R.id.tv_resturant, 3);
        sViewsWithIds.put(R.id.tv_supermart, 4);
        sViewsWithIds.put(R.id.nav_view, 5);
        sViewsWithIds.put(R.id.close, 6);
        sViewsWithIds.put(R.id.sv_left_header, 7);
        sViewsWithIds.put(R.id.llprofile, 8);
        sViewsWithIds.put(R.id.cv_uploadimage, 9);
        sViewsWithIds.put(R.id.Author_Avatar, 10);
        sViewsWithIds.put(R.id.Author_DisplayName, 11);
        sViewsWithIds.put(R.id.Author_UserName, 12);
        sViewsWithIds.put(R.id.llhome, 13);
        sViewsWithIds.put(R.id.llcart, 14);
        sViewsWithIds.put(R.id.llmyorder, 15);
        sViewsWithIds.put(R.id.ll_change_pws, 16);
        sViewsWithIds.put(R.id.llpaymet, 17);
        sViewsWithIds.put(R.id.llnotifi, 18);
        sViewsWithIds.put(R.id.llabout, 19);
        sViewsWithIds.put(R.id.llcontact, 20);
        sViewsWithIds.put(R.id.llangages, 21);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityHomeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 22, sIncludes, sViewsWithIds));
    }
    private ActivityHomeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[10]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[12]
            , (android.widget.ImageView) bindings[6]
            , (androidx.cardview.widget.CardView) bindings[9]
            , (androidx.drawerlayout.widget.DrawerLayout) bindings[0]
            , (android.widget.LinearLayout) bindings[16]
            , (android.widget.LinearLayout) bindings[19]
            , (android.widget.LinearLayout) bindings[21]
            , (android.widget.LinearLayout) bindings[14]
            , (android.widget.LinearLayout) bindings[20]
            , (android.widget.LinearLayout) bindings[13]
            , (android.widget.LinearLayout) bindings[15]
            , (android.widget.LinearLayout) bindings[18]
            , (android.widget.LinearLayout) bindings[17]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.ImageView) bindings[2]
            , (com.google.android.material.navigation.NavigationView) bindings[5]
            , (android.widget.RelativeLayout) bindings[1]
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[4]
            );
        this.drawerLayout.setTag(null);
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