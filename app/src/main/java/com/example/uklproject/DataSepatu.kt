package com.example.ukl

import com.example.uklproject.Sepatu

object DataSepatu {
    private val data = arrayOf(
        arrayOf(
            "Air Jordan 1 Low Pastel Purple",
            "Rp.3.799.000",
            "https://images.tokopedia.net/img/cache/500-square/VqbcmM/2022/11/19/2b695056-e960-4a33-84a9-11c2e5408660.jpg"
        ),
        arrayOf(
            "Air Jordan 1 Mid Stealth",
            "Rp.3.499.000",
            "https://cf.shopee.co.id/file/sg-11134201-22110-eys92w1xp0jvbc"
        ),
        arrayOf(
            "Air Jordan 1 Low Slate Blue",
            "Rp.2.799.000",
            "https://images.tokopedia.net/img/cache/500-square/VqbcmM/2022/5/18/911a864b-85f2-4618-b7f9-1e771f438548.jpg"
        ),
        arrayOf(
            "Air Jordan 1 High Zoom Celestine Blue",
            "Rp.3.699.000",
            "https://images.tokopedia.net/img/cache/500-square/VqbcmM/2022/2/22/b12b04a2-2aad-49f7-9e7a-212258fdde9a.jpg"
        ),
        arrayOf(
            "Air Jordan 1 Low(GS) Brushstroke",
            "Rp.3.799.000",
            "https://cf.shopee.co.id/file/edf8599b723318cabdd6d2cf69bfbf76"
        ),
        arrayOf(
            "Air Jordan 1 Mid(GS) Zen Master",
            "Rp.2.999.000",
            "https://orca-photo.shopback.co.id/rtRJ7mgIZJITwNNYk5r5RqMrpmDITFzUfMKwoplJCqk/resize:fill:292:292:1/gravity:no/aHR0cHM6Ly93d3cu/c3RhdGljLXNyYy5j/b20vd2Nzc3RvcmUv/SW5kcmFwcmFzdGhh/L2ltYWdlcy9jYXRh/bG9nL21lZGl1bS8v/OTQvTVRBLTUxODUy/NDQyL2Fpcl9qb3Jk/YW5fYWlyX2pvcmRh/bl8xX21pZF8tZ3Mt/X3plbl9tYXN0ZXJf/ZnVsbDAyX2x2Z3F5/OWZhLmpwZw.jpg"
        ),
        arrayOf(
            "Air Jordan 1 Low University Blue",
            "Rp.3.399.000",
            "https://www.static-src.com/wcsstore/Indraprastha/images/catalog/full//107/MTA-38639680/nike_nike_air_jordan_1_low_university_blue_football_grey_women_sizing_full04_e5yzkwbg.jpg"
        ),
        arrayOf(
            "Air Jordan 1 Low Alumunium",
            "Rp.3.499.000",
            "https://images.tokopedia.net/img/cache/500-square/VqbcmM/2022/12/11/9f2742ab-e471-41a4-8f8e-556dff055cc2.jpg"
        ),
        arrayOf(
            "Air Jordan 1 Mid Light Iron",
            "Rp.3.499.000",
            "https://807garage.com/wp-content/uploads/2022/03/2E449AB5-9DA9-4C2B-9022-C3506F2368C4.jpg"
        ),
        arrayOf(
            "Air Jordan 1 High Zoom Pink Oxford",
            "Rp.4.199.000",
            "https://www.static-src.com/wcsstore/Indraprastha/images/catalog/full//98/MTA-51982343/air_jordan_air_jordan_1_high_zoom_pink_oxford_full01_e2lisrc.jpg"
        )
    )
    val listData : ArrayList<Sepatu>
        get(){
            val list = arrayListOf<Sepatu>()
            for(aData in data){
                val sepatu = Sepatu()
                sepatu.name = aData[0]
                sepatu.harga = aData[1]
                sepatu.photo = aData[2]

                list.add(sepatu)
            }
            return list
        }

}