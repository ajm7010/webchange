(ns webchange.editor-v2.graph-builder.graph.phrases-graph--cinema-video-source)

(def data {:assets
                          [{:url "/raw/img/cinema/background.jpg", :size 10, :type "image"}
                           {:url "/raw/img/cinema/screen-off.png", :size 10, :type "image"}
                           {:url "/raw/img/ui/play_button_01.png", :size 10, :type "image"}
                           {:url "/raw/img/ui/next_button_01.png", :size 10, :type "image"}
                           {:url "/raw/audio/l2/a1/L2_A1_Mari.m4a", :size 5, :type "audio", :alias "vaca voice 1"}
                           {:url "/raw/audio/l2/a1/L2_A1_Vaca_7.m4a", :size 5, :type "audio", :alias "vaca voice 7"}
                           {:url   "/raw/audio/l2/a2/L2_A2_Vaca_Insertions/L2_A2_Insertions_1.m4a",
                            :size  2,
                            :type  "audio",
                            :alias "vaca insertions 1"}
                           {:url   "/raw/audio/l2/a2/L2_A2_Vaca_Insertions/L2_A2_Insertions_2.m4a",
                            :size  2,
                            :type  "audio",
                            :alias "vaca insertions 2"}
                           {:url   "/raw/audio/l2/a2/L2_A2_Vaca_Insertions/L2_A2_Insertions_3.m4a",
                            :size  2,
                            :type  "audio",
                            :alias "vaca insertions 3"}
                           {:url   "/raw/audio/l2/a2/L2_A2_Vaca_Insertions/L2_A2_Insertions_4.m4a",
                            :size  2,
                            :type  "audio",
                            :alias "vaca insertions 4"}
                           {:url   "/raw/audio/l2/a2/L2_A2_Vaca_Insertions/L2_A2_Insertions_5.m4a",
                            :size  2,
                            :type  "audio",
                            :alias "vaca insertions 5"}
                           {:url   "/raw/audio/l2/a2/L2_A2_Vaca_Insertions/L2_A2_Insertions_6.m4a",
                            :size  2,
                            :type  "audio",
                            :alias "vaca insertions 6"}
                           {:url   "/raw/audio/l2/a2/L2_A2_Vaca_Insertions/L2_A2_Insertions_7.m4a",
                            :size  2,
                            :type  "audio",
                            :alias "vaca insertions 7"}
                           {:url   "/raw/audio/l2/a2/L2_A2_Vaca_Insertions/L2_A2_Insertions_8.m4a",
                            :size  2,
                            :type  "audio",
                            :alias "vaca insertions 8"}
                           {:url   "/raw/audio/l2/a2/L2_A2_Vaca_Insertions/L2_A2_Insertions_9.m4a",
                            :size  2,
                            :type  "audio",
                            :alias "vaca insertions 9"}
                           {:url   "/raw/audio/l2/a2/L2_A2_Vaca_Insertions/L2_A2_Insertions_10.m4a",
                            :size  2,
                            :type  "audio",
                            :alias "vaca insertions 10"}
                           {:url   "/raw/audio/l2/a2/L2_A2_Vaca_Insertions/L2_A2_Insertions_11.m4a",
                            :size  2,
                            :type  "audio",
                            :alias "vaca insertions 11"}],
           :objects
                          {:background {:type "background", :src "/raw/img/cinema/background.jpg"},
                           :letter-video
                                       {:type   "transparent",
                                        :x      342,
                                        :y      111,
                                        :width  1236,
                                        :height 674,
                                        :states {:hidden {:type "transparent"}, :visible {:type "video"}}},
                           :mari
                                       {:type       "animation",
                                        :x          1613,
                                        :y          785,
                                        :width      473,
                                        :height     511,
                                        :transition "mari",
                                        :anim       "idle",
                                        :name       "mari",
                                        :scale-x    0.3,
                                        :scale-y    0.3,
                                        :speed      0.35,
                                        :start      true},
                           :next-button
                                       {:type    "transparent",
                                        :x       400,
                                        :y       0,
                                        :width   331,
                                        :height  98,
                                        :actions {:click {:id "finish-activity", :on "click", :type "action"}},
                                        :src     "/raw/img/ui/next_button_01.png",
                                        :states  {:hidden {:y 1000, :type "transparent"}, :visible {:y 0, :type "image"}}},
                           :play-button
                                       {:type    "image",
                                        :x       0,
                                        :y       0,
                                        :width   331,
                                        :height  99,
                                        :actions {:click {:id "play-video", :on "click", :type "action"}},
                                        :src     "/raw/img/ui/play_button_01.png",
                                        :states  {:left {:x 0}, :center {:x 200}}},
                           :screen-overlay
                                       {:type   "image",
                                        :x      342,
                                        :y      109,
                                        :width  1238,
                                        :height 678,
                                        :src    "/raw/img/cinema/screen-off.png",
                                        :states {:hidden {:type "transparent"}, :visible {:type "image"}}},
                           :senora-vaca
                                       {:type    "animation",
                                        :x       263,
                                        :y       915,
                                        :width   351,
                                        :height  717,
                                        :anim    "idle",
                                        :name    "senoravaca",
                                        :scale-x 0.5,
                                        :scale-y 0.5,
                                        :skin    "vaca",
                                        :speed   0.3,
                                        :start   true},
                           :video-controls
                                       {:type     "transparent",
                                        :x        616,
                                        :y        400,
                                        :width    730,
                                        :height   100,
                                        :children ["play-button" "next-button"],
                                        :states   {:hidden {:type "transparent"}, :visible {:type "group"}}}},
           :scene-objects [["background"] ["letter-video" "screen-overlay"] ["video-controls"] ["senora-vaca" "mari"]],
           :actions
                          {:clear-instruction {:type "remove-flows", :description "Remove flows", :flow-tag "instruction"},
                           :finish-activity
                                              {:type "sequence-data", :data [{:id "cinema-video", :type "finish-activity"} {:type "scene", :scene-id "map"}]},
                           :hide-play-form
                                              {:type "parallel",
                                               :data
                                                     [{:id "hidden", :type "state", :target "video-controls"}
                                                      {:to {:x 1613, :y 785, :loop false, :duration 1.5}, :type "transition", :transition-id "mari"}]},
                           :mari-voice-touch
                                              {:phrase                 :touch
                                               :phrase-description     "Touch to play"
                                               :offset                 12.841,
                                               :phrase-text            "Touch here to view the video",
                                               :phrase-text-translated "Toca aqui para ver el video",
                                               :start                  12.841,
                                               :type                   "animation-sequence",
                                               :duration               2.479,
                                               :audio                  "mari",
                                               :target                 "mari",
                                               :track                  1,
                                               :data                   [{:end 15.205, :anim "talk", :start 12.994}]},
                           :mari-voice-touch-again-1
                                              {:offset                 18.667,
                                               :phrase-text            "Touch here to view the video again",
                                               :phrase-text-translated "Toca aqui para ver el video de nuevo",
                                               :start                  18.667,
                                               :type                   "animation-sequence",
                                               :duration               3.271,
                                               :audio                  "mari",
                                               :target                 "mari",
                                               :track                  1,
                                               :data                   [{:end 21.861, :anim "talk", :start 18.82}]},
                           :mari-voice-touch-again-2
                                              {:offset                 22.36,
                                               :phrase-text            "or touch here to go to your next activity.\n"
                                               :phrase-text-translated "o toca aqui para ir a tu proxima actividad.",
                                               :start                  22.36,
                                               :type                   "animation-sequence",
                                               :duration               4.025,
                                               :audio                  "mari",
                                               :target                 "mari",
                                               :track                  1,
                                               :data                   [{:end 26.257, :anim "talk", :start 22.475}]},
                           :play-video
                                              {:type "sequence-data",
                                               :data
                                                     [{:id "hide-play-form", :type "action"}
                                                      {:id "hidden", :type "state", :target "screen-overlay"}
                                                      {:id "visible", :type "state", :target "letter-video"}
                                                      {:type     "play-video",
                                                       :target   "letter-video",
                                                       :from-var [{:var-name "current-concept", :var-property "chanting-video-src", :action-property "src"}]}
                                                      {:id "play-video-finish", :type "action"}]},
                           :play-video-finish
                                              {:phrase             :finish
                                               :phrase-description "Play video finish"
                                               :type               "sequence-data",
                                               :data
                                                                   [{:id "hidden", :type "state", :target "letter-video"}
                                                                    {:id "visible", :type "state", :target "screen-overlay"}
                                                                    {:id "vaca-clapping", :type "action"}
                                                                    {:id "vaca-voice-very-good", :type "action"}
                                                                    {:id "show-play-again-form", :type "action"}]},
                           :renew-concept
                                              {:type "lesson-var-provider", :from "concepts-single", :provider-id "concepts", :variables ["current-concept"]},
                           :show-play-again-form
                                              {:type "sequence-data",
                                               :data
                                                     [{:data
                                                             [{:id "visible", :type "state", :target "next-button"}
                                                              {:id "left", :type "state", :target "play-button"}
                                                              {:id "visible", :type "state", :target "video-controls"}],
                                                       :type "parallel"}
                                                      {:to {:x 990, :y 540, :loop false, :duration 1.5}, :type "transition", :transition-id "mari"}
                                                      {:id "mari-voice-touch-again-1", :type "action"}
                                                      {:to {:x 1400, :y 540, :loop false, :duration 1.5}, :type "transition", :transition-id "mari"}
                                                      {:id "mari-voice-touch-again-2", :type "action"}]},
                           :show-play-form
                                              {:type "sequence-data",
                                               :data
                                                     [{:data
                                                             [{:id "hidden", :type "state", :target "next-button"}
                                                              {:id "center", :type "state", :target "play-button"}
                                                              {:id "visible", :type "state", :target "video-controls"}],
                                                       :type "parallel"}
                                                      {:to {:x 1223, :y 546, :loop false, :duration 1.5}, :type "transition", :transition-id "mari"}
                                                      {:id "mari-voice-touch", :type "action"}]},
                           :start-scene
                                              {:type        "sequence",
                                               :data
                                                            ["start-activity"
                                                             "clear-instruction"
                                                             "renew-concept"
                                                             "vaca-voice-wonderful"
                                                             "vaca-voice-lets-watch"
                                                             "show-play-form"],
                                               :description "Initial action"},
                           :start-activity    {:type "start-activity", :id "cinema-video"},
                           :stop-activity     {:type "stop-activity", :id "cinema-video"},
                           :vaca-clapping
                                              {:type "sequence-data",
                                               :data
                                                     [{:id "clapping_start", :loop false, :type "animation", :target "senoravaca"}
                                                      {:data   [{:end 3, :anim "clapping_1clap", :start 0}],
                                                       :type   "animation-sequence",
                                                       :track  1,
                                                       :offset 0,
                                                       :target "senoravaca"}
                                                      {:id "clapping_finish", :loop false, :type "animation", :target "senoravaca"}]},
                           :vaca-voice-lets-watch
                                              {:type               "sequence-data",
                                               :phrase             :lets-watch
                                               :phrase-description "Lets watch video"
                                               :data
                                                                   [{:phrase-text            "Excellent! Now, let’s watch a video about the letter",
                                                                     :phrase-text-translated "Ahora veamos un video sobre la letra",
                                                                     :offset                 21.15,
                                                                     :start                  21.15,
                                                                     :type                   "animation-sequence",
                                                                     :duration               4.769,
                                                                     :audio                  "/raw/audio/l2/a1/L2_A1_Vaca_7.m4a",
                                                                     :target                 "senoravaca",
                                                                     :track                  1,
                                                                     :data                   [{:end 24.15, :anim "talk", :start 21.33} {:end 25.53, :anim "talk", :start 24.46}]}
                                                                    {:type "action", :from-var [{:var-name "current-concept", :var-property "letter-intro-letter"}]}]},
                           :vaca-voice-very-good
                                              {:offset      27.148,
                                               :phrase-text "Very good!",
                                               :start       27.148,
                                               :type        "animation-sequence",
                                               :duration    1.532,
                                               :audio       "/raw/audio/l2/a1/L2_A1_Vaca_7.m4a",
                                               :target      "senoravaca",
                                               :track       1,
                                               :data        [{:end 28.618, :anim "talk", :start 27.297}]},
                           :vaca-voice-wonderful
                                              {:offset                 9.716,
                                               :phrase                 :intro
                                               :phrase-description     "Intro"
                                               :phrase-text            "Wonderful! That was good singing everyone! Are you having a good time?",
                                               :phrase-text-translated "Maravilloso! Todos cantaron muy bien!  Amigas, estan pasando un buen rato?",
                                               :start                  9.716,
                                               :type                   "animation-sequence",
                                               :duration               10.613,
                                               :audio                  "/raw/audio/l2/a1/L2_A1_Vaca_7.m4a",
                                               :target                 "senoravaca",
                                               :track                  1,
                                               :data
                                                                       [{:end 11.858, :anim "talk", :start 10.04}
                                                                        {:end 14.723, :anim "talk", :start 12.431}
                                                                        {:end 16.691, :anim "talk", :start 15.695}
                                                                        {:end 19.979, :anim "talk", :start 17.115}]}},
           :triggers      {:back {:on "back", :action "stop-activity"}, :start {:on "start", :action "start-scene"}},
           :metadata      {:prev "map", :autostart true},
           :audio         {:mari "/raw/audio/l2/a1/L2_A1_Mari.m4a", :vaca-7 "/raw/audio/l2/a1/L2_A1_Vaca_7.m4a"}}
  )
