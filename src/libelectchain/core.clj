(ns libelectchain.core
  (:require [buddy.core.keys :as keys]
            [buddy.core.dsa :as dsa]))

(def blockchain (atom {}))
(def pending (atom (vector)))



(defn append [to coin sig]
  (let [item {:to to :coin coin :sig sig}]
    (swap! pending conj item)))

(defn foo "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
