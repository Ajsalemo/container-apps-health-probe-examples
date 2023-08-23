<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use Illuminate\Support\Facades\Log;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});

Route::prefix('probe')->group(function() {
    Route::get('/http', function(Request $request) {
        $res = ['msg' => 'HTTP probe'];
        Log::info("Receiving request from an HTTP probe..");
        Log::info($request->headers->all());
        return response()->json($res, 200);
    });

    Route::get('/https', function(Request $request) {
        $res = ['msg' => 'HTTPS probe'];
        Log::info("Receiving request from an HTTPS probe..");
        Log::info($request->headers->all());
        return response()->json($res, 200);
    });
});

