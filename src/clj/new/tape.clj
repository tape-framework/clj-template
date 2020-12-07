(ns clj.new.tape
  (:require [clj.new.templates :refer [renderer project-data ->files]]))

(defn tape
  "Generate a Tape Framework app."
  [name]
  (let [render (renderer "tape")
        data   (project-data name)]
    (println "Generating " (str name) " Tape Framework app.")
    (->files data
             ["deps.edn" (render "deps.edn" data)]
             ["dev.cljs.edn" (render "dev.cljs.edn" data)]
             ["dev/src/cljs/user.cljs" (render "dev/src/cljs/user.cljs" data)]
             ["dev/src/{{nested-dirs}}/dev.cljs" (render "dev/src/name/dev.cljs" data)]

             ["resources/{{nested-dirs}}/config.edn" (render "resources/name/config.edn")]
             ["resources/public/index.html" (render "resources/public/index.html")]
             ["resources/public/favicon.ico" (render "resources/public/favicon.ico")]
             ["resources/public/css/style.css" (render "resources/public/css/style.css")]

             ["src/{{nested-dirs}}/core.cljs" (render "src/name/core.cljs" data)]
             ["src/{{nested-dirs}}/app/layouts/view.cljs" (render "src/name/app/layouts/view.cljs" data)]
             ["src/{{nested-dirs}}/app/hello/controller.cljs" (render "src/name/app/hello/controller.cljs" data)]
             ["src/{{nested-dirs}}/app/hello/view.cljs" (render "src/name/app/hello/view.cljs" data)])))
