package tomp2p.opuswrapper;

import com.sun.jna.*;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.ptr.ShortByReference;
import su.plo.voice.opus.OpusLibrary;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

/**
 * This is taken from <a href="https://github.com/tbocek/opus-wrapper">https://github.com/tbocek/opus-wrapper</a><br>
 * Slight modification to how it loads the native library.<br>
 * Credit for creation of this wrapper goes to the original developer:
 * <a href="https://github.com/tbocek">Thomas Bocek (tbocek)</a>
 * <p>
 * Completely removed all of the javadoc in this class because it was terrible and throwing errors when gradle
 * attempted to create javadoc for it. If you want to see the javadoc, please refer to the the original developer's
 * Github repo.
 */
public interface Opus extends Library {
    Opus INSTANCE = Native.load(NativeLibrary.getInstance(OpusLibrary.loadFromJar()).getFile().getAbsolutePath(), Opus.class);

    //  ****** Constants

    int OPUS_GET_LSB_DEPTH_REQUEST = 4037;

    int OPUS_GET_APPLICATION_REQUEST = 4001;

    int OPUS_GET_FORCE_CHANNELS_REQUEST = 4023;

    int OPUS_GET_VBR_REQUEST = 4007;

    int OPUS_GET_BANDWIDTH_REQUEST = 4009;

    int OPUS_SET_BITRATE_REQUEST = 4002;

    int OPUS_SET_BANDWIDTH_REQUEST = 4008;

    int OPUS_SIGNAL_MUSIC = 3002;

    int OPUS_RESET_STATE = 4028;

    int OPUS_FRAMESIZE_2_5_MS = 5001;

    int OPUS_GET_COMPLEXITY_REQUEST = 4011;

    int OPUS_FRAMESIZE_40_MS = 5005;

    int OPUS_SET_PACKET_LOSS_PERC_REQUEST = 4014;

    int OPUS_GET_VBR_CONSTRAINT_REQUEST = 4021;

    int OPUS_SET_INBAND_FEC_REQUEST = 4012;

    int OPUS_APPLICATION_RESTRICTED_LOWDELAY = 2051;

    int OPUS_BANDWIDTH_FULLBAND = 1105;

    int OPUS_SET_VBR_REQUEST = 4006;

    int OPUS_BANDWIDTH_SUPERWIDEBAND = 1104;

    int OPUS_SET_FORCE_CHANNELS_REQUEST = 4022;

    int OPUS_APPLICATION_VOIP = 2048;

    int OPUS_SIGNAL_VOICE = 3001;

    int OPUS_GET_FINAL_RANGE_REQUEST = 4031;

    int OPUS_BUFFER_TOO_SMALL = -2;

    int OPUS_SET_COMPLEXITY_REQUEST = 4010;

    int OPUS_FRAMESIZE_ARG = 5000;

    int OPUS_GET_LOOKAHEAD_REQUEST = 4027;

    int OPUS_GET_INBAND_FEC_REQUEST = 4013;

    int OPUS_BITRATE_MAX = -1;

    int OPUS_FRAMESIZE_5_MS = 5002;

    int OPUS_BAD_ARG = -1;

    int OPUS_GET_PITCH_REQUEST = 4033;

    int OPUS_SET_SIGNAL_REQUEST = 4024;

    int OPUS_FRAMESIZE_20_MS = 5004;

    int OPUS_APPLICATION_AUDIO = 2049;

    int OPUS_GET_DTX_REQUEST = 4017;

    int OPUS_FRAMESIZE_10_MS = 5003;

    int OPUS_SET_LSB_DEPTH_REQUEST = 4036;

    int OPUS_UNIMPLEMENTED = -5;

    int OPUS_GET_PACKET_LOSS_PERC_REQUEST = 4015;

    int OPUS_INVALID_STATE = -6;

    int OPUS_SET_EXPERT_FRAME_DURATION_REQUEST = 4040;

    int OPUS_FRAMESIZE_60_MS = 5006;

    int OPUS_GET_BITRATE_REQUEST = 4003;

    int OPUS_INTERNAL_ERROR = -3;

    int OPUS_SET_MAX_BANDWIDTH_REQUEST = 4004;

    int OPUS_SET_VBR_CONSTRAINT_REQUEST = 4020;

    int OPUS_GET_MAX_BANDWIDTH_REQUEST = 4005;

    int OPUS_BANDWIDTH_NARROWBAND = 1101;

    int OPUS_SET_GAIN_REQUEST = 4034;

    int OPUS_SET_PREDICTION_DISABLED_REQUEST = 4042;

    int OPUS_SET_APPLICATION_REQUEST = 4000;

    int OPUS_SET_DTX_REQUEST = 4016;

    int OPUS_BANDWIDTH_MEDIUMBAND = 1102;

    int OPUS_GET_SAMPLE_RATE_REQUEST = 4029;

    int OPUS_GET_EXPERT_FRAME_DURATION_REQUEST = 4041;

    int OPUS_AUTO = -1000;

    int OPUS_GET_SIGNAL_REQUEST = 4025;

    int OPUS_GET_LAST_PACKET_DURATION_REQUEST = 4039;

    int OPUS_GET_PREDICTION_DISABLED_REQUEST = 4043;

    int OPUS_GET_GAIN_REQUEST = 4045;

    int OPUS_BANDWIDTH_WIDEBAND = 1103;

    int OPUS_INVALID_PACKET = -4;

    int OPUS_ALLOC_FAIL = -7;

    int OPUS_OK = 0;


    int OPUS_MULTISTREAM_GET_DECODER_STATE_REQUEST = 5122;

    int OPUS_MULTISTREAM_GET_ENCODER_STATE_REQUEST = 5120;


    int opus_encoder_get_size(int channels);

    PointerByReference opus_encoder_create(int Fs, int channels, int application, IntBuffer error);

    int opus_encoder_init(PointerByReference st, int Fs, int channels, int application);

    int opus_encode(PointerByReference st, ShortBuffer pcm, int frame_size, ByteBuffer data, int max_data_bytes);

    int opus_encode(PointerByReference st, ShortByReference pcm, int frame_size, Pointer data, int max_data_bytes);

    int opus_encode_float(PointerByReference st, float[] pcm, int frame_size, ByteBuffer data, int max_data_bytes);

    int opus_encode_float(PointerByReference st, FloatByReference pcm, int frame_size, Pointer data, int max_data_bytes);

    void opus_encoder_destroy(PointerByReference st);

    int opus_encoder_ctl(PointerByReference st, int request, Object... varargs);

    int opus_decoder_get_size(int channels);

    PointerByReference opus_decoder_create(int Fs, int channels, IntBuffer error);

    int opus_decoder_init(PointerByReference st, int Fs, int channels);

    int opus_decode(PointerByReference st, byte[] data, int len, ShortBuffer pcm, int frame_size, int decode_fec);

    int opus_decode(PointerByReference st, Pointer data, int len, ShortByReference pcm, int frame_size, int decode_fec);

    int opus_decode_float(PointerByReference st, byte[] data, int len, FloatBuffer pcm, int frame_size, int decode_fec);

    int opus_decode_float(PointerByReference st, Pointer data, int len, FloatByReference pcm, int frame_size, int decode_fec);

    int opus_decoder_ctl(PointerByReference st, int request, Object... varargs);

    void opus_decoder_destroy(PointerByReference st);

    int opus_packet_parse(byte[] data, int len, ByteBuffer out_toc, byte[] frames, ShortBuffer size, IntBuffer payload_offset);

    int opus_packet_get_bandwidth(byte[] data);

    int opus_packet_get_samples_per_frame(byte[] data, int Fs);

    int opus_packet_get_nb_channels(byte[] data);

    int opus_packet_get_nb_frames(byte[] packet, int len);

    int opus_packet_get_nb_samples(byte[] packet, int len, int Fs);

    int opus_decoder_get_nb_samples(PointerByReference dec, byte[] packet, int len);

    int opus_decoder_get_nb_samples(PointerByReference dec, Pointer packet, int len);

    void opus_pcm_soft_clip(FloatBuffer pcm, int frame_size, int channels, FloatBuffer softclip_mem);

    int opus_repacketizer_get_size();

    PointerByReference opus_repacketizer_init(PointerByReference rp);

    PointerByReference opus_repacketizer_create();

    void opus_repacketizer_destroy(PointerByReference rp);

    int opus_repacketizer_cat(PointerByReference rp, byte[] data, int len);

    int opus_repacketizer_cat(PointerByReference rp, Pointer data, int len);

    int opus_repacketizer_out_range(PointerByReference rp, int begin, int end, ByteBuffer data, int maxlen);

    int opus_repacketizer_out_range(PointerByReference rp, int begin, int end, Pointer data, int maxlen);

    int opus_repacketizer_get_nb_frames(PointerByReference rp);

    int opus_repacketizer_out(PointerByReference rp, ByteBuffer data, int maxlen);

    int opus_repacketizer_out(PointerByReference rp, Pointer data, int maxlen);

    int opus_packet_pad(ByteBuffer data, int len, int new_len);

    int opus_packet_unpad(ByteBuffer data, int len);

    int opus_multistream_packet_pad(ByteBuffer data, int len, int new_len, int nb_streams);

    int opus_multistream_packet_unpad(ByteBuffer data, int len, int nb_streams);
    class OpusDecoder extends PointerType {
        public OpusDecoder(Pointer address) {
            super(address);
        }
        public OpusDecoder() {
            super();
        }
    }

    class OpusEncoder extends PointerType {
        public OpusEncoder(Pointer address) {
            super(address);
        }
        public OpusEncoder() {
            super();
        }
    }

    class OpusRepacketizer extends PointerType {
        public OpusRepacketizer(Pointer address) {
            super(address);
        }
        public OpusRepacketizer() {
            super();
        }
    }


    String opus_strerror(int error);

    String opus_get_version_string();

    int opus_multistream_encoder_get_size(int streams, int coupled_streams);

    int opus_multistream_surround_encoder_get_size(int channels, int mapping_family);

    PointerByReference opus_multistream_encoder_create(int Fs, int channels, int streams, int coupled_streams, byte[] mapping, int application, IntBuffer error);

    PointerByReference opus_multistream_surround_encoder_create(int Fs, int channels, int mapping_family, IntBuffer streams, IntBuffer coupled_streams, ByteBuffer mapping, int application, IntBuffer error);

    int opus_multistream_encoder_init(PointerByReference st, int Fs, int channels, int streams, int coupled_streams, byte[] mapping, int application);

    int opus_multistream_encoder_init(PointerByReference st, int Fs, int channels, int streams, int coupled_streams, Pointer mapping, int application);

    int opus_multistream_surround_encoder_init(PointerByReference st, int Fs, int channels, int mapping_family, IntBuffer streams, IntBuffer coupled_streams, ByteBuffer mapping, int application);

    int opus_multistream_surround_encoder_init(PointerByReference st, int Fs, int channels, int mapping_family, IntByReference streams, IntByReference coupled_streams, Pointer mapping, int application);

    int opus_multistream_encode(PointerByReference st, ShortBuffer pcm, int frame_size, ByteBuffer data, int max_data_bytes);

    int opus_multistream_encode(PointerByReference st, ShortByReference pcm, int frame_size, Pointer data, int max_data_bytes);

    int opus_multistream_encode_float(PointerByReference st, float[] pcm, int frame_size, ByteBuffer data, int max_data_bytes);

    int opus_multistream_encode_float(PointerByReference st, FloatByReference pcm, int frame_size, Pointer data, int max_data_bytes);

    void opus_multistream_encoder_destroy(PointerByReference st);

    int opus_multistream_encoder_ctl(PointerByReference st, int request, Object... varargs);

    int opus_multistream_decoder_get_size(int streams, int coupled_streams);

    PointerByReference opus_multistream_decoder_create(int Fs, int channels, int streams, int coupled_streams, byte[] mapping, IntBuffer error);

    int opus_multistream_decoder_init(PointerByReference st, int Fs, int channels, int streams, int coupled_streams, byte[] mapping);

    int opus_multistream_decoder_init(PointerByReference st, int Fs, int channels, int streams, int coupled_streams, Pointer mapping);

    int opus_multistream_decode(PointerByReference st, byte[] data, int len, ShortBuffer pcm, int frame_size, int decode_fec);

    int opus_multistream_decode(PointerByReference st, Pointer data, int len, ShortByReference pcm, int frame_size, int decode_fec);

    int opus_multistream_decode_float(PointerByReference st, byte[] data, int len, FloatBuffer pcm, int frame_size, int decode_fec);

    int opus_multistream_decode_float(PointerByReference st, Pointer data, int len, FloatByReference pcm, int frame_size, int decode_fec);

    int opus_multistream_decoder_ctl(PointerByReference st, int request, Object... varargs);

    void opus_multistream_decoder_destroy(PointerByReference st);
    class OpusMSEncoder extends PointerType {
        public OpusMSEncoder(Pointer address) {
            super(address);
        }
        public OpusMSEncoder() {
            super();
        }
    }

    class OpusMSDecoder extends PointerType {
        public OpusMSDecoder(Pointer address) {
            super(address);
        }
        public OpusMSDecoder() {
            super();
        }
    }

    PointerByReference opus_custom_mode_create(int Fs, int frame_size, IntBuffer error);

    void opus_custom_mode_destroy(PointerByReference mode);

    int opus_custom_encoder_get_size(PointerByReference mode, int channels);

    PointerByReference opus_custom_encoder_create(PointerByReference mode, int channels, IntBuffer error);

    PointerByReference opus_custom_encoder_create(PointerByReference mode, int channels, IntByReference error);

    void opus_custom_encoder_destroy(PointerByReference st);

    int opus_custom_encode_float(PointerByReference st, float[] pcm, int frame_size, ByteBuffer compressed, int maxCompressedBytes);

    int opus_custom_encode_float(PointerByReference st, FloatByReference pcm, int frame_size, Pointer compressed, int maxCompressedBytes);

    int opus_custom_encode(PointerByReference st, ShortBuffer pcm, int frame_size, ByteBuffer compressed, int maxCompressedBytes);

    int opus_custom_encode(PointerByReference st, ShortByReference pcm, int frame_size, Pointer compressed, int maxCompressedBytes);

    int opus_custom_encoder_ctl(PointerByReference st, int request, Object... varargs);

    int opus_custom_decoder_get_size(PointerByReference mode, int channels);

    int opus_custom_decoder_init(PointerByReference st, PointerByReference mode, int channels);

    PointerByReference opus_custom_decoder_create(PointerByReference mode, int channels, IntBuffer error);

    PointerByReference opus_custom_decoder_create(PointerByReference mode, int channels, IntByReference error);

    void opus_custom_decoder_destroy(PointerByReference st);

    int opus_custom_decode_float(PointerByReference st, byte[] data, int len, FloatBuffer pcm, int frame_size);

    int opus_custom_decode_float(PointerByReference st, Pointer data, int len, FloatByReference pcm, int frame_size);

    int opus_custom_decode(PointerByReference st, byte[] data, int len, ShortBuffer pcm, int frame_size);

    int opus_custom_decode(PointerByReference st, Pointer data, int len, ShortByReference pcm, int frame_size);

    int opus_custom_decoder_ctl(PointerByReference st, int request, Object... varargs);
    class OpusCustomDecoder extends PointerType {
        public OpusCustomDecoder(Pointer address) {
            super(address);
        }
        public OpusCustomDecoder() {
            super();
        }
    }

    class OpusCustomEncoder extends PointerType {
        public OpusCustomEncoder(Pointer address) {
            super(address);
        }
        public OpusCustomEncoder() {
            super();
        }
    }

    class OpusCustomMode extends PointerType {
        public OpusCustomMode(Pointer address) {
            super(address);
        }
        public OpusCustomMode() {
            super();
        }
    }
}
