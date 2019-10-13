package json_reader_matkheev.sparkProject

import argonaut.Argonaut.casecodec14
import argonaut.CodecJson

case class Wine(id                     : Option[Int],
                country                : Option[String],
                description            : Option[String],
                designation            : Option[String],
                points                 : Option[Int],
                price                  : Option[Double],
                province               : Option[String],
                region_1               : Option[String],
                region_2               : Option[String],
                taster_name            : Option[String],
                taster_twitter_handle  : Option[String],
                title                  : Option[String],
                variety                : Option[String],
                winery                 : Option[String])

object Wine {
  implicit def WineCodecJson: CodecJson[Wine] =
    casecodec14(Wine.apply, Wine.unapply)("id", "country",
      "description", "designation", "points", "price", "province", "region_1", "region_2", "taster_name", "taster_twitter_handle", "title", "variety", "winery")

}
