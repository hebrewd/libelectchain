(ns libelectchain.core)

(def blockchain (atom {}))
(def pending (atom (vector)))

(def append [to coin sig]
  (let [item {:to to :coin coin :sig sig}]
    (swap! conj pending item)))

(defn foo "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
