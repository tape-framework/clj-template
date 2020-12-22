(ns {{namespace}}.app.hello.controller
  (:require [reitit.coercion.spec :as rcs]
            [tape.mvc.controller :as c :include-macros true]))

;;; Routes

(def ^::c/routes routes
  ["" {:coercion rcs/coercion}
   ["/say" ::index]])

;;; Handlers

(defn ^::c/event-db index [_db [_ev-id _params]]
  {::say "Hello Tape Framework!"})

;;; Subs

(defn ^::c/sub say [db _query]
  (::say db))

;;; Module

(c/defmodule)
