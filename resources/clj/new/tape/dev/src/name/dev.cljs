(ns ^:figwheel-hooks {{namespace}}.dev
  (:require [re-frame.core :as rf]
            [re-frame.db]
            [integrant.repl :as repl]
            [tape.module :as module :include-macros true]
            [{{namespace}}.core :as core]
            [tape.router :as router]
            [{{namespace}}.app.hello.controller :as hello.c]))

(def profiles [:tape.profile/dev :tape.profile/local])

(repl/set-prep! #(module/prep-config core/config profiles))

(defn go []
  (repl/go [::core/main :tape/multi]))

(defn ^:after-load on-reload []
  (swap! re-frame.db/app-db update :__figwheel_counter inc)
  (repl/reset))

(defonce init
  (do (go)
      (rf/dispatch-sync [::router/navigate [::hello.c/index]])))
