package ontime.app.databinding;
import ontime.app.R;
import ontime.app.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityRestaurantlistBindingImpl extends ActivityRestaurantlistBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.ll_back, 1);
        sViewsWithIds.put(R.id.ll_main, 2);
        sViewsWithIds.put(R.id.iv_search, 3);
        sViewsWithIds.put(R.id.txt_top, 4);
        sViewsWithIds.put(R.id.txt_near_me, 5);
        sViewsWithIds.put(R.id.iv_filter, 6);
        sViewsWithIds.put(R.id.ed_search, 7);
        sViewsWithIds.put(R.id.iv_menu, 8);
        sViewsWithIds.put(R.id.vp_banner, 9);
        sViewsWithIds.put(R.id.rv_list, 10);
        sViewsWithIds.put(R.id.nav_view, 11);
        sViewsWithIds.put(R.id.close, 12);
        sViewsWithIds.put(R.id.sv_left_header, 13);
        sViewsWithIds.put(R.id.llprofile, 14);
        sViewsWithIds.put(R.id.cv_uploadimage, 15);
        sViewsWithIds.put(R.id.Author_Avatar, 16);
        sViewsWithIds.put(R.id.Author_DisplayName, 17);
        sViewsWithIds.put(R.id.Author_UserName, 18);
        sViewsWithIds.put(R.id.llhome, 19);
        sViewsWithIds.put(R.id.txt_home, 20);
        sViewsWithIds.put(R.id.iv_home, 21);
        sViewsWithIds.put(R.id.llcart, 22);
        sViewsWithIds.put(R.id.txt_cart, 23);
        sViewsWithIds.put(R.id.iv_cart, 24);
        sViewsWithIds.put(R.id.llmyorder, 25);
        sViewsWithIds.put(R.id.txt_myorder, 26);
        sViewsWithIds.put(R.id.iv_myorder, 27);
        sViewsWithIds.put(R.id.ll_change_pws, 28);
        sViewsWithIds.put(R.id.txt_chang_pws, 29);
        sViewsWithIds.put(R.id.iv_chang_pws, 30);
        sViewsWithIds.put(R.id.llpaymet, 31);
        sViewsWithIds.put(R.id.txt_payment, 32);
        sViewsWithIds.put(R.id.iv_payment, 33);
        sViewsWithIds.put(R.id.llnotifi, 34);
        sViewsWithIds.put(R.id.txt_notification, 35);
        sViewsWithIds.put(R.id.iv_notification, 36);
        sViewsWithIds.put(R.id.llabout, 37);
        sViewsWithIds.put(R.id.txt_about_us, 38);
        sViewsWithIds.put(R.id.iv_about_us, 39);
        sViewsWithIds.put(R.id.llcontact, 40);
        sViewsWithIds.put(R.id.txt_contact_us, 41);
        sViewsWithIds.put(R.id.iv_contact_us, 42);
        sViewsWithIds.put(R.id.llangages, 43);
        sViewsWithIds.put(R.id.txt_Languages, 44);
        sViewsWithIds.put(R.id.iv_Languages, 45);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityRestaurantlistBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 46, sIncludes, sViewsWithIds));
    }
    private ActivityRestaurantlistBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[16]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[18]
            , (android.widget.ImageView) bindings[12]
            , (androidx.cardview.widget.CardView) bindings[15]
            , (androidx.drawerlayout.widget.DrawerLayout) bindings[0]
            , (android.widget.EditText) bindings[7]
            , (android.widget.ImageView) bindings[39]
            , (android.widget.ImageView) bindings[24]
            , (android.widget.ImageView) bindings[30]
            , (android.widget.ImageView) bindings[42]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.ImageView) bindings[21]
            , (android.widget.ImageView) bindings[45]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ImageView) bindings[27]
            , (android.widget.ImageView) bindings[36]
            , (android.widget.ImageView) bindings[33]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.LinearLayout) bindings[28]
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.LinearLayout) bindings[37]
            , (android.widget.LinearLayout) bindings[43]
            , (android.widget.LinearLayout) bindings[22]
            , (android.widget.LinearLayout) bindings[40]
            , (android.widget.LinearLayout) bindings[19]
            , (android.widget.LinearLayout) bindings[25]
            , (android.widget.LinearLayout) bindings[34]
            , (android.widget.LinearLayout) bindings[31]
            , (android.widget.LinearLayout) bindings[14]
            , (com.google.android.material.navigation.NavigationView) bindings[11]
            , (androidx.recyclerview.widget.RecyclerView) bindings[10]
            , (android.widget.LinearLayout) bindings[13]
            , (android.widget.TextView) bindings[38]
            , (android.widget.TextView) bindings[23]
            , (android.widget.TextView) bindings[29]
            , (android.widget.TextView) bindings[41]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[44]
            , (android.widget.TextView) bindings[26]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[35]
            , (android.widget.TextView) bindings[32]
            , (android.widget.TextView) bindings[4]
            , (androidx.viewpager.widget.ViewPager) bindings[9]
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