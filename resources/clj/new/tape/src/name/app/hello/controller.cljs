(ns {{namespace}}.app.hello.controller
  (:require [reitit.coercion.spec :as rcs]
            [tape.mvc.controller :as c :include-macros true]))

;;; Routes

(def ^{::c/reg ::c/routes} routes
  ["" {:coercion rcs/coercion}
   ["/say" ::index]])

;;; Handlers

(defn index
  {::c/reg ::c/event-db}
  [_db [_ev-id _params]]
  {::say "Hello Tape Framework!"})

;;; Subs

(defn say
  {::c/reg ::c/sub}
  [db _query] (::say db))

;;; Module

(c/defmodule)
