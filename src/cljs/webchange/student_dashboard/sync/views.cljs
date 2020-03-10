(ns webchange.student-dashboard.sync.views
  (:require
    [re-frame.core :as re-frame]
    [reagent.core :as r]
    [cljs-react-material-ui.icons :as ic]
    [cljs-react-material-ui.reagent :as ui]
    [webchange.sw-utils.message :as sw]
    [webchange.sw-utils.subs :as subs]
    [webchange.student-dashboard.sync.events :as events]
    [webchange.student-dashboard.sync.views-sync-list :refer [sync-list-modal]]))

(defn sync-status
  []
  (let [offline-mode @(re-frame/subscribe [::subs/offline-mode])]
    (case offline-mode
      :syncing [ic/cloud-download {:color "disabled"}]
      :synced [ic/cloud-done]
      [ic/cloud-off {:color "disabled"}])))

(defn current-version-data
  [{:keys [update-date-str version]}]
  (let [update (js/Date. update-date-str)
        update-date (.toLocaleDateString update)
        update-time (.toLocaleTimeString update)]
    [:div
     [:div {:style {:display   "flex"
                    :font-size 10
                    :height    15}}
      [:div {:style {:width 50}} "Version:"]
      [:div
       [:span {:style {:height 14}} version]]]
     [:div {:style {:display   "flex"
                    :font-size 10}}
      [:div {:style {:width 50}} "Updated:"]
      [:div {:style {:display        "flex"
                     :flex-direction "column"}}
       [:span {:style {:height 14}} update-time]
       [:span {:style {:height 14}} update-date]]]]))

(defn current-version
  []
  (sw/get-last-update)
  (let [last-update @(re-frame/subscribe [::subs/last-update])
        version @(re-frame/subscribe [::subs/version])]
    [ui/menu-item
     {:disabled true
      :style    {:height          50
                 :justify-content "center"
                 :padding-top     0
                 :padding-bottom  0}}
     (if (nil? last-update)
       [ui/circular-progress
        {:size 24}]
       [current-version-data {:update-date-str last-update
                              :version         version}])]))

(defn sync-control
  []
  (r/with-let [menu-anchor (r/atom nil)]
              (let [handle-select-resources-click #(do (reset! menu-anchor nil)
                                                       (re-frame/dispatch [::events/open-sync-list]))]
                [:div
                 [ui/icon-button
                  {:on-click #(reset! menu-anchor (.-currentTarget %))}
                  [sync-status]]
                 [ui/menu
                  {:anchor-el               @menu-anchor
                   :open                    (boolean @menu-anchor)
                   :disable-auto-focus-item true
                   :on-close                #(reset! menu-anchor nil)}
                  [ui/menu-item
                   {:on-click handle-select-resources-click}
                   "Select Resources"]
                  [ui/divider]
                  [current-version]]
                 [sync-list-modal]])))
