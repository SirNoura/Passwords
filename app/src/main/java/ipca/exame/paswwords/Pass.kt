package ipca.exame.paswwords

import androidx.room.*

@Entity(tableName = "tbl_pass")
data class Pass(
    @PrimaryKey var strPass: String,
    var strSite: String?,
    var strdescricao: String,
    var strData : String
)