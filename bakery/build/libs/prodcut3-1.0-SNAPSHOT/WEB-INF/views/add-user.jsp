<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="d" tagdir="/WEB-INF/tags" %>
<d:layout>
    <jsp:attribute name="head">
        <!-- Title -->
        <title>Dashboard | Front - Admin &amp; Dashboard Template</title>
    </jsp:attribute>
    <jsp:attribute name="content">
        <main id="content" role="main" class="main">
            <!-- content -->
            <div class="content container-fluid">
                <!-- step form -->
                 <form class="js-step-form py-md-5" data-hs-step-form-options='{
                        "progressselector": "#adduserstepformprogress",
                        "stepsselector": "#adduserstepformcontent",
                        "endselector": "#adduserfinishbtn",
                         "isvalidate": false}'>
                     <div class="row justify-content-lg-center">
                         <div class="col-lg-8">
                                <!-- step -->
                                <!-- end step -->
                                <!-- content step form -->
                             <div id="adduserstepformcontent">
                                 <!-- card -->
                                 <div id="adduserstepprofile" class="card card-lg active">
                                         <!-- body -->
                                     <div class="card-body">
                                        <!-- form group -->
                                        <div class="row form-group">
                                            <label class="col-sm-3 col-form-label input-label">
                                                avatar
                                            </label>
                                            <div class="col-sm-9">
                                                <div class="d-flex align-items-center">
                                                    <!-- avatar -->
                                                    <label class="avatar avatar-xl avatar-circle avatar-uploader mr-5"
                                                           for="avataruploader">
                                                        <img id="avatarimg" class="avatar-img" src="\assets\img\160x160\img1.jpg" alt="image description">
                                                        <input type="file" class="js-file-attach avatar-uploader-input"
                                                                id="avataruploader" data-hs-file-attach-options='{
                                                                "texttarget": "#avatarimg",
                                                                "mode": "image",
                                                                "targetattr": "src",
                                                                "resettarget": ".js-file-attach-reset-img",
                                                                "resetimg": "./\assets/img/160x160/img1.jpg",
                                                                "allowtypes": [".png", ".jpeg", ".jpg"]}'>
                                                        <span class="avatar-uploader-trigger">
                                                            <i class="tio-edit avatar-uploader-icon shadow-soft"></i>
                                                        </span>
                                                    </label>
                                                    <!-- end avatar -->
                                                    <button type="button" class="js-file-attach-reset-img btn btn-white">
                                                        delete
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                         <!-- end form group -->

                                         <!-- form group -->
                                         <div class="row form-group">
                                             <label for="firstnamelabel" class="col-sm-3 col-form-label input-label">full name <i
                                                     class="tio-help-outlined text-body ml-1" data-toggle="tooltip"
                                                     data-placement="top" title="displayed on public forums, such as front."></i>
                                             </label>
                                             <div class="col-sm-9">
                                                 <div class="input-group input-group-sm-down-break">
                                                     <input type="text" class="form-control" name="firstname" id="firstnamelabel"
                                                                 placeholder="clarice" aria-label="clarice">
                                                 </div>
                                             </div>
                                         </div>
                                         <!-- end form group -->

                                         <!-- form group -->
                                         <div class="row form-group">
                                            <label for="emaillabel" class="col-sm-3 col-form-label input-label">
                                                email
                                            </label>
                                            <div class="col-sm-9">
                                                <input type="email" class="form-control" name="email" id="emaillabel"
                                               placeholder="clarice@example.com" aria-label="clarice@example.com">
                                             </div>
                                         </div>
                                         <!-- end form group -->
                                         <!-- form group -->
                                        <div class="js-add-field row form-group" data-hs-add-field-options='{
                                            "template": "#addphonefieldtemplate",
                                            "container": "#addphonefieldcontainer",
                                            "defaultcreated": 0}'>
                                             <label for="phonelabel" class="col-sm-3 col-form-label input-label">phone <span
                                                 class="input-label-secondary">(optional)</span>
                                             </label>
                                            <div class="col-sm-9">
                                                <div class="input-group input-group-sm-down-break align-items-center">
                                                    <input type="text" class="js-masked-input form-control" name="phone"
                                                             id="phonelabel" placeholder="+x(xxx)xxx-xx-xx"
                                                                aria-label="+x(xxx)xxx-xx-xx" data-hs-mask-options='{
                                                                 "template": "+0(000)000-00-00"}'>
                                                </div>
                                                    <!-- container for input field -->
                                                    <div id="addphonefieldcontainer"></div>
                                                </div>
                                            </div>
                                             <!-- end form group -->

                                             <!-- add phone input field -->
                                            <div id="addaddressfieldtemplate" style="display: none;">
                                                <div class="input-group-add-field">
                                                    <input type="text" class="form-control" data-name="addressline"
                                                         placeholder="your address" aria-label="your address">
                                                        <a class="js-delete-field input-group-add-field-delete" href="javascript:;">
                                                            <i class="tio-clear"></i>
                                                        </a>
                                                </div>
                                            </div>
                                            <!-- end add phone input field -->
                                            <!-- add phone input field -->
                                            <div id="addphonefieldtemplate" class="input-group-add-field" style="display: none;">
                                                <div class="input-group input-group-sm-down-break align-items-center">
                                                    <input type="text" class="js-masked-input form-control"
                                                        data-name="additionlphone" placeholder="+x(xxx)xxx-xx-xx"
                                                        aria-label="+x(xxx)xxx-xx-xx" data-hs-mask-options='{
                                                        "template": "+0(000)000-00-00"}'>
                                                    <div class="input-group-append">
                                                         <!-- select -->
                                                        <div class="select2-custom">
                                                            <select class="js-select2-custom-dynamic custom-select" size="1"
                                                                style="opacity: 0;" data-name="additionlphoneselect"
                                                                data-hs-select2-options='{
                                                                 "minimumresultsforsearch": "infinity",
                                                                "dropdownautowidth": true,
                                                                "width": "6rem"}'>
                                                                <option value="mobile" selected="">mobile</option>
                                                                <option value="home">home</option>
                                                                <option value="work">work</option>
                                                                <option value="fax">fax</option>
                                                                <option value="direct">direct</option>
                                                            </select>
                                                        </div>
                                                        <!-- end select -->
                                                    </div>
                                                </div>
                                                <a class="js-delete-field input-group-add-field-delete" href="javascript:;">
                                                    <i class="tio-clear"></i>
                                                </a>
                                            </div>

                                         <div class="row form-group">
                                             <label for="addresslabel" class="col-sm-3 col-form-label input-label">
                                                 address
                                             </label>
                                             <div class="col-sm-9">
                                                 <input type="text" class="form-control" name="address" id="addresslabel"
                                                        placeholder="Viet Nam">
                                             </div>
                                         </div>
                                            <!-- end add phone input field -->

                                            <!-- form group (organization)-->
                                             <!-- end form group -->

                                            <!-- form group (department) -->
                                            <!-- end form group -->

                                            <!-- form group (account type)-->
                                            <!-- end form group -->
                                        </div>
                                        <!-- end body -->
                                        <!-- footer -->
                                        <div class="card-footer d-flex justify-content-end align-items-center">
                                            <button type="button" class="btn btn-primary" data-hs-step-form-next-options='{
                                                "targetselector": "#adduserstepbillingaddress"}'>
                                                next <i class="tio-chevron-right"></i>
                                            </button>
                                        </div>
                                        <!-- end footer -->
                                     </div>
                                        <!-- end card -->
                                </div>
                                     <!-- end content step form -->
                                 <!-- message body -->
                                 <div id="successmessagecontent" style="display:none;">
                                      <div class="text-center">
                                         <img class="img-fluid mb-3" src="\assets\svg\illustrations\hi-five.svg"
                                             alt="image description" style="max-width: 15rem;">
                                                <div class="mb-4">
                                                    <h2>successful!</h2>
                                                    <p>new <span class="font-weight-bold text-dark">ella lauda</span> user has been successfully created.</p>
                                                </div>
                                      <div class="d-flex justify-content-center">
                                            <a class="btn btn-white mr-3" href="users.html">
                                                <i class="tio-chevron-left ml-1"></i> back to users
                                            </a>
                                            <a class="btn btn-primary" href="users-add-user.html">
                                                 <i class="tio-user-add mr-1"></i> add new user
                                            </a>
                                      </div>
                                 </div>
                             </div>
                            <!-- end message body -->
                         </div>
                     </div>
                    <!-- end row -->
                 </form>
                    <!-- end step form -->
            </div>
                    <!-- end content -->
                <!-- footer -->
            <div class="footer">
                <div class="row justify-content-between align-items-center">
                   <div class="col">
                        <p class="font-size-sm mb-0">&copy; front. <span
                        class="d-none d-sm-inline-block">2020 htmlstream.</span></p>
                   </div>

                    <div class="col-auto">
                        <div class="d-flex justify-content-end">
                             <!-- list dot -->
                            <ul class="list-inline list-separator">
                                <li class="list-inline-item">
                                    <a class="list-separator-link" href="#">faq</a>
                                </li>
                                <li class="list-inline-item">
                                    <a class="list-separator-link" href="#">license</a>
                                </li>
                                <li class="list-inline-item">
                                    <!-- keyboard shortcuts toggle -->
                                    <div class="hs-unfold">
                                        <a class="js-hs-unfold-invoker btn btn-icon btn-ghost-secondary rounded-circle"
                                           href="javascript:;" data-hs-unfold-options='{
                                               "target": "#keyboardshortcutssidebar",
                                               "type": "css-animation",
                                               "animationin": "fadeinright",
                                               "animationout": "fadeoutright",
                                               "hasoverlay": true,
                                               "smartpositionoff": true}'>
                                               <i class="tio-command-key"></i>
                                        </a>
                                    </div>
                                                <!-- end keyboard shortcuts toggle -->
                                </li>
                            </ul>
                        <!-- end list dot -->
                        </div>
                    </div>
                </div>
            </div>
            <!-- end footer -->
        </main>
    </jsp:attribute>
</d:layout>