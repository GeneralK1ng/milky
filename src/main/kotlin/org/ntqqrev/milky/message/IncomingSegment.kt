package org.ntqqrev.milky.message

import org.ntqqrev.saltify.composeidl.*

val IncomingResourceSegmentBase = Struct {
    field("resource_id", StringType, "资源 ID")
    field("temp_url", StringType, "临时 URL")
}

val IncomingSegment = DiscriminatedUnion("IncomingSegment", "type") {
    describe("接收消息段")

    structPlacedInto("data")

    defineSharedSegment()

    struct("reply") {
        describe("回复消息段")
        field("message_seq", LongType, "被引用的消息序列号")
    }

    struct("image") {
        describe("图片消息段")
        use(IncomingResourceSegmentBase)
        field("summary", StringType, "图片预览文本") { optional() }
        field("sub_type", StringType, "图片类型") {
            enum("normal", "sticker")
        }
    }

    struct("record") {
        describe("语音消息段")
        use(IncomingResourceSegmentBase)
        field("duration", IntType, "语音时长（秒）")
    }

    struct("video") {
        describe("视频消息段")
        use(IncomingResourceSegmentBase)
    }

    struct("forward") {
        describe("合并转发消息段")
        field("forward_id", StringType, "合并转发 ID")
    }

    struct("market_face") {
        describe("市场表情消息段")
        field("url", StringType, "市场表情 URL")
    }

    struct("light_app") {
        describe("小程序消息段")
        field("app_name", StringType, "小程序名称")
        field("json_payload", StringType, "小程序 JSON 数据")
    }

    struct("xml") {
        describe("XML 消息段")
        field("service_id", IntType, "服务 ID")
        field("xml_payload", StringType, "XML 数据")
    }
}