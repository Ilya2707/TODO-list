package Model.network

import com.squareup.moshi.Json

data class LocalNames (

    @Json(name ="ar"           ) var ar          : String? = null,
    @Json(name ="ascii"        ) var ascii       : String? = null,
    @Json(name ="bg"           ) var bg          : String? = null,
    @Json(name ="ca"           ) var ca          : String? = null,
    @Json(name ="de"           ) var de          : String? = null,
    @Json(name ="el"           ) var el          : String? = null,
    @Json(name ="en"           ) var en          : String? = null,
    @Json(name ="fa"           ) var fa          : String? = null,
    @Json(name ="feature_name" ) var featureName : String? = null,
    @Json(name ="fi"           ) var fi          : String? = null,
    @Json(name ="fr"           ) var fr          : String? = null,
    @Json(name ="gl"           ) var gl          : String? = null,
    @Json(name ="he"           ) var he          : String? = null,
    @Json(name ="hi"           ) var hi          : String? = null,
    @Json(name ="id"           ) var id          : String? = null,
    @Json(name ="it"           ) var it          : String? = null,
    @Json(name ="ja"           ) var ja          : String? = null,
    @Json(name ="la"           ) var la          : String? = null,
    @Json(name ="lt"           ) var lt          : String? = null,
    @Json(name ="pt"           ) var pt          : String? = null,
    @Json(name ="ru"           ) var ru          : String? = null,
    @Json(name ="sr"           ) var sr          : String? = null,
    @Json(name ="th"           ) var th          : String? = null,
    @Json(name ="tr"           ) var tr          : String? = null,
    @Json(name ="vi"           ) var vi          : String? = null,
    @Json(name ="zu"           ) var zu          : String? = null

)

data class ReverseGeocoding (

    @Json(name ="name"        ) var name       : String?     = null,
    @Json(name ="local_names" ) var localNames : LocalNames? = LocalNames(),
    @Json(name ="lat"         ) var lat        : Double?     = null,
    @Json(name ="lon"         ) var lon        : Double?     = null,
    @Json(name ="country"     ) var country    : String?     = null

)