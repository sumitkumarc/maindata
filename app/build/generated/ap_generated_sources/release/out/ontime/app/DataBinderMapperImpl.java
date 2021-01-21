package ontime.app;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import ontime.app.databinding.ActivityAboutusBindingImpl;
import ontime.app.databinding.ActivityCartBindingImpl;
import ontime.app.databinding.ActivityChangePasswordBindingImpl;
import ontime.app.databinding.ActivityContactusBindingImpl;
import ontime.app.databinding.ActivityForgetPageBindingImpl;
import ontime.app.databinding.ActivityHomeBindingImpl;
import ontime.app.databinding.ActivityLanguageBindingImpl;
import ontime.app.databinding.ActivityLoginBindingImpl;
import ontime.app.databinding.ActivityMurNotificationBindingImpl;
import ontime.app.databinding.ActivityMyordersBindingImpl;
import ontime.app.databinding.ActivityNewOrderItemListBindingImpl;
import ontime.app.databinding.ActivityNotificationBindingImpl;
import ontime.app.databinding.ActivityOrdersummaryBindingImpl;
import ontime.app.databinding.ActivityPaymentBindingImpl;
import ontime.app.databinding.ActivityProfileBindingImpl;
import ontime.app.databinding.ActivityRegistetPageBindingImpl;
import ontime.app.databinding.ActivityRestaurantlistBindingImpl;
import ontime.app.databinding.ActivityRestdetailBindingImpl;
import ontime.app.databinding.ActivityRestprofileBindingImpl;
import ontime.app.databinding.ActivitySentrequestBindingImpl;
import ontime.app.databinding.ActivityVerifyPageBindingImpl;
import ontime.app.databinding.CRowCategoryListItemBindingImpl;
import ontime.app.databinding.RActivityRiderorderdetailsBindingImpl;
import ontime.app.databinding.RFragmentNewOrderBindingImpl;
import ontime.app.databinding.RowItemPaymentMethordBindingImpl;
import ontime.app.databinding.TabOrderProcessingBindingImpl;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYABOUTUS = 1;

  private static final int LAYOUT_ACTIVITYCART = 2;

  private static final int LAYOUT_ACTIVITYCHANGEPASSWORD = 3;

  private static final int LAYOUT_ACTIVITYCONTACTUS = 4;

  private static final int LAYOUT_ACTIVITYFORGETPAGE = 5;

  private static final int LAYOUT_ACTIVITYHOME = 6;

  private static final int LAYOUT_ACTIVITYLANGUAGE = 7;

  private static final int LAYOUT_ACTIVITYLOGIN = 8;

  private static final int LAYOUT_ACTIVITYMURNOTIFICATION = 9;

  private static final int LAYOUT_ACTIVITYMYORDERS = 10;

  private static final int LAYOUT_ACTIVITYNEWORDERITEMLIST = 11;

  private static final int LAYOUT_ACTIVITYNOTIFICATION = 12;

  private static final int LAYOUT_ACTIVITYORDERSUMMARY = 13;

  private static final int LAYOUT_ACTIVITYPAYMENT = 14;

  private static final int LAYOUT_ACTIVITYPROFILE = 15;

  private static final int LAYOUT_ACTIVITYREGISTETPAGE = 16;

  private static final int LAYOUT_ACTIVITYRESTAURANTLIST = 17;

  private static final int LAYOUT_ACTIVITYRESTDETAIL = 18;

  private static final int LAYOUT_ACTIVITYRESTPROFILE = 19;

  private static final int LAYOUT_ACTIVITYSENTREQUEST = 20;

  private static final int LAYOUT_ACTIVITYVERIFYPAGE = 21;

  private static final int LAYOUT_CROWCATEGORYLISTITEM = 22;

  private static final int LAYOUT_RACTIVITYRIDERORDERDETAILS = 23;

  private static final int LAYOUT_RFRAGMENTNEWORDER = 24;

  private static final int LAYOUT_ROWITEMPAYMENTMETHORD = 25;

  private static final int LAYOUT_TABORDERPROCESSING = 26;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(26);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(ontime.app.R.layout.activity_aboutus, LAYOUT_ACTIVITYABOUTUS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ontime.app.R.layout.activity_cart, LAYOUT_ACTIVITYCART);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ontime.app.R.layout.activity_change_password, LAYOUT_ACTIVITYCHANGEPASSWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ontime.app.R.layout.activity_contactus, LAYOUT_ACTIVITYCONTACTUS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ontime.app.R.layout.activity_forget_page, LAYOUT_ACTIVITYFORGETPAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ontime.app.R.layout.activity_home, LAYOUT_ACTIVITYHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ontime.app.R.layout.activity_language, LAYOUT_ACTIVITYLANGUAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ontime.app.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ontime.app.R.layout.activity_mur_notification, LAYOUT_ACTIVITYMURNOTIFICATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ontime.app.R.layout.activity_myorders, LAYOUT_ACTIVITYMYORDERS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ontime.app.R.layout.activity_new_order_item_list, LAYOUT_ACTIVITYNEWORDERITEMLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ontime.app.R.layout.activity_notification, LAYOUT_ACTIVITYNOTIFICATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ontime.app.R.layout.activity_ordersummary, LAYOUT_ACTIVITYORDERSUMMARY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ontime.app.R.layout.activity_payment, LAYOUT_ACTIVITYPAYMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ontime.app.R.layout.activity_profile, LAYOUT_ACTIVITYPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ontime.app.R.layout.activity_registet_page, LAYOUT_ACTIVITYREGISTETPAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ontime.app.R.layout.activity_restaurantlist, LAYOUT_ACTIVITYRESTAURANTLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ontime.app.R.layout.activity_restdetail, LAYOUT_ACTIVITYRESTDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ontime.app.R.layout.activity_restprofile, LAYOUT_ACTIVITYRESTPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ontime.app.R.layout.activity_sentrequest, LAYOUT_ACTIVITYSENTREQUEST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ontime.app.R.layout.activity_verify_page, LAYOUT_ACTIVITYVERIFYPAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ontime.app.R.layout.c_row_category_list_item, LAYOUT_CROWCATEGORYLISTITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ontime.app.R.layout.r_activity_riderorderdetails, LAYOUT_RACTIVITYRIDERORDERDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ontime.app.R.layout.r_fragment_new_order, LAYOUT_RFRAGMENTNEWORDER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ontime.app.R.layout.row_item_payment_methord, LAYOUT_ROWITEMPAYMENTMETHORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ontime.app.R.layout.tab_order_processing, LAYOUT_TABORDERPROCESSING);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYABOUTUS: {
          if ("layout/activity_aboutus_0".equals(tag)) {
            return new ActivityAboutusBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_aboutus is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYCART: {
          if ("layout/activity_cart_0".equals(tag)) {
            return new ActivityCartBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_cart is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYCHANGEPASSWORD: {
          if ("layout/activity_change_password_0".equals(tag)) {
            return new ActivityChangePasswordBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_change_password is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYCONTACTUS: {
          if ("layout/activity_contactus_0".equals(tag)) {
            return new ActivityContactusBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_contactus is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYFORGETPAGE: {
          if ("layout/activity_forget_page_0".equals(tag)) {
            return new ActivityForgetPageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_forget_page is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYHOME: {
          if ("layout/activity_home_0".equals(tag)) {
            return new ActivityHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_home is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLANGUAGE: {
          if ("layout/activity_language_0".equals(tag)) {
            return new ActivityLanguageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_language is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLOGIN: {
          if ("layout/activity_login_0".equals(tag)) {
            return new ActivityLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMURNOTIFICATION: {
          if ("layout/activity_mur_notification_0".equals(tag)) {
            return new ActivityMurNotificationBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_mur_notification is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMYORDERS: {
          if ("layout/activity_myorders_0".equals(tag)) {
            return new ActivityMyordersBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_myorders is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYNEWORDERITEMLIST: {
          if ("layout/activity_new_order_item_list_0".equals(tag)) {
            return new ActivityNewOrderItemListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_new_order_item_list is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYNOTIFICATION: {
          if ("layout/activity_notification_0".equals(tag)) {
            return new ActivityNotificationBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_notification is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYORDERSUMMARY: {
          if ("layout/activity_ordersummary_0".equals(tag)) {
            return new ActivityOrdersummaryBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_ordersummary is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPAYMENT: {
          if ("layout/activity_payment_0".equals(tag)) {
            return new ActivityPaymentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_payment is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPROFILE: {
          if ("layout/activity_profile_0".equals(tag)) {
            return new ActivityProfileBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_profile is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYREGISTETPAGE: {
          if ("layout/activity_registet_page_0".equals(tag)) {
            return new ActivityRegistetPageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_registet_page is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYRESTAURANTLIST: {
          if ("layout/activity_restaurantlist_0".equals(tag)) {
            return new ActivityRestaurantlistBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_restaurantlist is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYRESTDETAIL: {
          if ("layout/activity_restdetail_0".equals(tag)) {
            return new ActivityRestdetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_restdetail is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYRESTPROFILE: {
          if ("layout/activity_restprofile_0".equals(tag)) {
            return new ActivityRestprofileBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_restprofile is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSENTREQUEST: {
          if ("layout/activity_sentrequest_0".equals(tag)) {
            return new ActivitySentrequestBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_sentrequest is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYVERIFYPAGE: {
          if ("layout/activity_verify_page_0".equals(tag)) {
            return new ActivityVerifyPageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_verify_page is invalid. Received: " + tag);
        }
        case  LAYOUT_CROWCATEGORYLISTITEM: {
          if ("layout/c_row_category_list_item_0".equals(tag)) {
            return new CRowCategoryListItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for c_row_category_list_item is invalid. Received: " + tag);
        }
        case  LAYOUT_RACTIVITYRIDERORDERDETAILS: {
          if ("layout/r_activity_riderorderdetails_0".equals(tag)) {
            return new RActivityRiderorderdetailsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for r_activity_riderorderdetails is invalid. Received: " + tag);
        }
        case  LAYOUT_RFRAGMENTNEWORDER: {
          if ("layout/r_fragment_new_order_0".equals(tag)) {
            return new RFragmentNewOrderBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for r_fragment_new_order is invalid. Received: " + tag);
        }
        case  LAYOUT_ROWITEMPAYMENTMETHORD: {
          if ("layout/row_item_payment_methord_0".equals(tag)) {
            return new RowItemPaymentMethordBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for row_item_payment_methord is invalid. Received: " + tag);
        }
        case  LAYOUT_TABORDERPROCESSING: {
          if ("layout/tab_order_processing_0".equals(tag)) {
            return new TabOrderProcessingBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for tab_order_processing is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(26);

    static {
      sKeys.put("layout/activity_aboutus_0", ontime.app.R.layout.activity_aboutus);
      sKeys.put("layout/activity_cart_0", ontime.app.R.layout.activity_cart);
      sKeys.put("layout/activity_change_password_0", ontime.app.R.layout.activity_change_password);
      sKeys.put("layout/activity_contactus_0", ontime.app.R.layout.activity_contactus);
      sKeys.put("layout/activity_forget_page_0", ontime.app.R.layout.activity_forget_page);
      sKeys.put("layout/activity_home_0", ontime.app.R.layout.activity_home);
      sKeys.put("layout/activity_language_0", ontime.app.R.layout.activity_language);
      sKeys.put("layout/activity_login_0", ontime.app.R.layout.activity_login);
      sKeys.put("layout/activity_mur_notification_0", ontime.app.R.layout.activity_mur_notification);
      sKeys.put("layout/activity_myorders_0", ontime.app.R.layout.activity_myorders);
      sKeys.put("layout/activity_new_order_item_list_0", ontime.app.R.layout.activity_new_order_item_list);
      sKeys.put("layout/activity_notification_0", ontime.app.R.layout.activity_notification);
      sKeys.put("layout/activity_ordersummary_0", ontime.app.R.layout.activity_ordersummary);
      sKeys.put("layout/activity_payment_0", ontime.app.R.layout.activity_payment);
      sKeys.put("layout/activity_profile_0", ontime.app.R.layout.activity_profile);
      sKeys.put("layout/activity_registet_page_0", ontime.app.R.layout.activity_registet_page);
      sKeys.put("layout/activity_restaurantlist_0", ontime.app.R.layout.activity_restaurantlist);
      sKeys.put("layout/activity_restdetail_0", ontime.app.R.layout.activity_restdetail);
      sKeys.put("layout/activity_restprofile_0", ontime.app.R.layout.activity_restprofile);
      sKeys.put("layout/activity_sentrequest_0", ontime.app.R.layout.activity_sentrequest);
      sKeys.put("layout/activity_verify_page_0", ontime.app.R.layout.activity_verify_page);
      sKeys.put("layout/c_row_category_list_item_0", ontime.app.R.layout.c_row_category_list_item);
      sKeys.put("layout/r_activity_riderorderdetails_0", ontime.app.R.layout.r_activity_riderorderdetails);
      sKeys.put("layout/r_fragment_new_order_0", ontime.app.R.layout.r_fragment_new_order);
      sKeys.put("layout/row_item_payment_methord_0", ontime.app.R.layout.row_item_payment_methord);
      sKeys.put("layout/tab_order_processing_0", ontime.app.R.layout.tab_order_processing);
    }
  }
}
