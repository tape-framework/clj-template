(ns {{namespace}}.app.hello.view
  (:require [tape.mvc :as mvc :include-macros true]
            [tape.tools :as tools :include-macros true]
            [{{namespace}}.app.hello.controller :as hello.c]))

;;; Views

(defn index
  {::mvc/reg ::mvc/view}
  []
  (let [say @(tools/subscribe [hello.c/say])]
    [:p.hello-tape say]))

;;; Module

(mvc/defm ::module)
