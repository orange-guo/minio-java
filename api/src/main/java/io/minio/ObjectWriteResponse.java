/*
 * MinIO Java SDK for Amazon S3 Compatible Cloud Storage, (C) 2020 MinIO, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.minio;

import io.minio.messages.CompleteMultipartUploadOutput;
import io.minio.messages.CopyObjectResult;
import okhttp3.Headers;

/** Response class of any APIs doing object creation. */
public class ObjectWriteResponse extends GenericResponse {
  private String etag;
  private String versionId;
  private String checksumCRC32;
  private String checksumCRC32C;
  private String checksumSHA1;
  private String checksumSHA256;

  public ObjectWriteResponse(
      Headers headers, String bucket, String region, String object, String etag, String versionId) {
    super(headers, bucket, region, object);
    this.etag = etag;
    this.versionId = versionId;
    if (headers != null) {
      this.checksumCRC32 = headers.get("x-amz-checksum-crc32");
      this.checksumCRC32C = headers.get("x-amz-checksum-crc32c");
      this.checksumSHA1 = headers.get("x-amz-checksum-sha1");
      this.checksumSHA256 = headers.get("x-amz-checksum-sha256");
    }
  }

  public ObjectWriteResponse(
      Headers headers,
      String bucket,
      String region,
      String object,
      String etag,
      String versionId,
      CopyObjectResult result) {
    super(headers, bucket, region, object);
    this.etag = etag;
    this.versionId = versionId;
    if (result != null) {
      this.checksumCRC32 = result.checksumCRC32();
      this.checksumCRC32C = result.checksumCRC32C();
      this.checksumSHA1 = result.checksumSHA1();
      this.checksumSHA256 = result.checksumSHA256();
    }
  }

  public ObjectWriteResponse(
      Headers headers,
      String bucket,
      String region,
      String object,
      String etag,
      String versionId,
      CompleteMultipartUploadOutput result) {
    super(headers, bucket, region, object);
    this.etag = etag;
    this.versionId = versionId;
    if (result != null) {
      this.checksumCRC32 = result.checksumCRC32();
      this.checksumCRC32C = result.checksumCRC32C();
      this.checksumSHA1 = result.checksumSHA1();
      this.checksumSHA256 = result.checksumSHA256();
    }
  }

  public String etag() {
    return etag;
  }

  public String versionId() {
    return versionId;
  }

  public String checksumCRC32() {
    return checksumCRC32;
  }

  public String checksumCRC32C() {
    return checksumCRC32C;
  }

  public String checksumSHA1() {
    return checksumSHA1;
  }

  public String checksumSHA256() {
    return checksumSHA256;
  }
}
