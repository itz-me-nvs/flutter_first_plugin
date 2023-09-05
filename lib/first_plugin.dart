// You have generated a new plugin project without specifying the `--platforms`
// flag. A plugin project with no platform support was generated. To add a
// platform, run `flutter create -t plugin --platforms <platforms> .` under the
// same directory. You can also find a detailed instruction on how to add
// platforms in the `pubspec.yaml` at
// https://flutter.dev/docs/development/packages-and-plugins/developing-packages#plugin-platforms.

import 'package:flutter/services.dart';

import 'first_plugin_platform_interface.dart';

class FirstPlugin {
  Future<String?> getPlatformVersion() {
    return FirstPluginPlatform.instance.getPlatformVersion();
  }

  final MethodChannel _channel = MethodChannel('first_plugin_channel');

  Future<String> greet() async {
    try {
      return await _channel.invokeMethod('greetMe');
    } catch (e) {
      throw Exception('Error invoking yourPluginMethod: $e');
    }
  }
}
