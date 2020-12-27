(ns {{namespace}}.app.hello.view
  (:require [tape.mvc.view :as v :include-macros true]
            [tape.tools :as tools :include-macros true]
            [{{namespace}}.app.hello.controller :as hello.c]))

;;; Views

(defn index
  {::v/reg ::v/view}
  []
  (let [say @(tools/subscribe [hello.c/say])]
    [:p.hello-tape say]))

;;; Module

(v/defmodule)
