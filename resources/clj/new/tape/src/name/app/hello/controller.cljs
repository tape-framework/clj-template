(ns {{namespace}}.app.hello.controller
  (:require [reitit.coercion.spec :as rcs]
            [tape.mvc :as mvc :include-macros true]))

;;; Routes

(def ^{::mvc/reg ::mvc/routes} routes
  ["" {:coercion rcs/coercion}
   ["/say" ::index]])

;;; Handlers

(defn index
  {::mvc/reg ::mvc/event-db}
  [_db [_ev-id _params]]
  {::say "Hello Tape Framework!"})

;;; Subs

(defn say
  {::mvc/reg ::mvc/sub}
  [db _query] (::say db))

;;; Module

(mvc/defm ::module)
