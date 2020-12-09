(ns {{namespace}}.core
  (:require
   [goog.dom]
   [integrant.core :as ig]
   [reagent.dom :as dom]
   [re-frame.core :as rf]
   [tape.module :as module :include-macros true]
   [tape.mvc :as mvc :include-macros true]
   [tape.router :as router]
   [tape.tools.timeouts.controller]
   [tape.tools.intervals.controller]
   [tape.toasts.controller]
   [{{namespace}}.app.layouts.app :as app]
   [{{namespace}}.app.hello.controller :as hello.c]))

(mvc/require-modules "src/{{nested-dirs}}/app")

(module/load-hierarchy)

(defmethod ig/init-key ::main [_ _]
  (rf/dispatch-sync [::router/navigate [::hello.c/index]])
  (dom/render [app/app] (goog.dom/getElement "app")))

;;; System

(def ^:private modules-discovery (mvc/modules-discovery "src/{{nested-dirs}}/app"))

(def config
  (merge (module/read-config "{{nested-dirs}}/config.edn")
         (:modules modules-discovery)
         {:tape.profile/base {::router/routes (:routes modules-discovery)
                              :tape/router    {:routes  (ig/ref ::router/routes)
                                               :options {:conflicts nil}}
                              :tape.mvc/main  {:router :tape/router}
                              ::main          (ig/ref :tape.mvc/main)}}))
