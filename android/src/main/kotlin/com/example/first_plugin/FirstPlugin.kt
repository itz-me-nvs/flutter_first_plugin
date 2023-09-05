package com.example.first_plugin

import androidx.annotation.NonNull
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result as MethodChannelResult

// class FirstPlugin(private val flutterEngine: FlutterEngine) : MethodChannel.MethodCallHandler {
//     companion object {
//         fun registerWith(flutterEngine: FlutterEngine) {
//             val channel = MethodChannel(flutterEngine.dartExecutor.binaryMessenger, "first_plugin_channel")
//             val instance = FirstPlugin(flutterEngine)
//             channel.setMethodCallHandler(instance)
//         }
//     }

//     override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: MethodChannel.Result) {
//         when (call.method) {
//             "greetMe" -> {
//                 // Implement your greetMe logic here
//                 // For example, you can send a message back to Flutter
//                 result.success("Hello from Android!")
//             }
//             else -> result.notImplemented()
//         }
//     }
// }


class FirstPlugin: FlutterPlugin, MethodCallHandler {
    private lateinit var channel: MethodChannel

    override fun onAttachedToEngine(flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        channel = MethodChannel(flutterPluginBinding.binaryMessenger, "first_plugin_channel")
        channel.setMethodCallHandler(this)
}


override fun onMethodCall(call: MethodCall, result: MethodChannelResult) {
    when (call.method) {
        "greetMe" -> {
            // Implement your greetMe logic here
            result.success("Hello from Android!")
        }
    }
}

override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null)
}

}