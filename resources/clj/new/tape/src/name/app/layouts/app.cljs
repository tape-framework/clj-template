(ns {{namespace}}.app.layouts.app
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [tape.mvc.view :as v]
            [tape.tools.current.controller :as current.c]
            [tape.router :as router]
            [tape.toasts.view :as toasts.v]))


(defn app []
  (let [current-view-fn @(rf/subscribe [::current.c/view-fn])]
    [:<>
     [:section.section
      [:div.container
       (when (some? current-view-fn)
         [current-view-fn])]]
     [toasts.v/index]]))
