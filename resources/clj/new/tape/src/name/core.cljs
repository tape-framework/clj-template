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
   [{{namespace}}.app.layouts.app :as app]))

(mvc/require-modules "src/{{nested-dirs}}/app")

(module/load-hierarchy)

(defmethod ig/init-key ::main [_ _]
  (dom/render [app/app] (goog.dom/getElement "app")))

;;; System

(def config
  (merge (mvc/modules-map "src/{{nested-dirs}}/app")
         (module/read-config "{{nested-dirs}}/config.edn")))
