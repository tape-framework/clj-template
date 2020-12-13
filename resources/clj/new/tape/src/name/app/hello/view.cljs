(ns {{namespace}}.app.hello.view
  (:require [re-frame.core :as rf]
            [tape.mvc.view :as v :include-macros true]
            [{{namespace}}.app.hello.controller :as hello.c]))

;;; Views

(defn ^::v/view index []
  (let [say @(v/subscribe [hello.c/say])]
    [:p.hello-tape say]))

;;; Module

(v/defmodule {{namespace}}.app.hello.controller)
