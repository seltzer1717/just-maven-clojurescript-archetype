(ns com.example.sample.core)

(defn reverso [halb]
  (.join (.reverse (.split halb "")) ""))
