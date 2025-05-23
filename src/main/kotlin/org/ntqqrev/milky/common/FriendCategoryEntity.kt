package org.ntqqrev.milky.common

import org.ntqqrev.saltify.composeidl.IntType
import org.ntqqrev.saltify.composeidl.StringType
import org.ntqqrev.saltify.composeidl.Struct

val FriendCategoryEntity = Struct("FriendCategory") {
    describe("好友分组")
    field("category_id", IntType, "好友分组 ID")
    field("category_name", StringType, "好友分组名称")
}